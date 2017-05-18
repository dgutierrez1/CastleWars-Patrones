package com.castlewars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.castlewars.CastleWars;
import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;
import com.castlewars.creational.factory_chainofresponsability.ActorFactory;
import com.castlewars.creational.factory_chainofresponsability.DragonFactory;
import com.castlewars.creational.factory_chainofresponsability.DragonRiderFactory;
import com.castlewars.creational.factory_chainofresponsability.LordFactory;
import com.castlewars.creational.factory_chainofresponsability.SpikesmanFactory;
import com.castlewars.processors.InferiorProcessor;
import com.castlewars.processors.Processor;
import com.castlewars.processors.SuperiorProcessor;

import com.castlewars.structural.flyweight.FlyweightFactory;

import java.util.HashMap;


/**
 * Created by Daniel Gutierrez on 7/05/2017.
 */

public abstract class GameScreenObserver extends BaseScreen {

    protected Stage stage;
    private World world;

    HashMap<String, KnightActor> superiorActorMap;
    HashMap<String, KnightActor> inferiorActorMap;

    HashMap<String, KnightActor> actorMap;


    private Skin skin;
    private TextButton play;

    public Processor superiorProcessor;
    public Processor inferiorProcessor;

    public ActorFactory factory;

    public GameScreenObserver(final CastleWars game) {
        super(game);
        stage = new Stage(new FitViewport(640, 360));
        world = new World(new Vector2(0, 0), true);
        world.setContactListener(new GameContactListener());
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        inferiorActorMap = new HashMap<String, KnightActor>();
        superiorActorMap =  new HashMap<String, KnightActor>();
        actorMap  =  new HashMap<String, KnightActor>();
        createFactories();
    }

    public void createFactories(){

        FlyweightFactory flyweightFactory = new FlyweightFactory();

        ActorFactory spikesmansFactory = new SpikesmanFactory(0,world, flyweightFactory);
        ActorFactory lordFactory = new LordFactory(1,world, flyweightFactory);
        ActorFactory dragonRiderFactory = new DragonRiderFactory(2,world, flyweightFactory);
        ActorFactory dragonFactory = new DragonFactory(3.0, world, flyweightFactory);

        spikesmansFactory.setNextFactory(lordFactory);
        lordFactory.setNextFactory(dragonRiderFactory);
        dragonRiderFactory.setNextFactory(dragonFactory);
        dragonFactory.setNextFactory(null);

        factory = spikesmansFactory;

    }

    public void deleteFromSuperiorList(String actor){

    }

    public abstract void update();

    @Override
    public void show() {
        InputMultiplexer multiplexer = new InputMultiplexer();

        play = new TextButton("Play", skin);

        play.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Take me to the game screen!
                //game.setScreen(game.gameScreen);
                Gdx.app.log("VERF", "button play");
                //game.startGame();

            }
        });

        play.setSize(200, 80);
        play.setPosition(40, 140);
        stage.addActor(play);
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(superiorProcessor);
        multiplexer.addProcessor(inferiorProcessor);

        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void hide() {
        stage.clear();
    }

    @Override
    public void dispose() {
        stage.dispose();
        world.dispose();
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.3f, 0.5f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        accumulate();
        world.step(delta, 6, 2);
        stage.draw();
    }

    public abstract void accumulate();

    private class GameContactListener implements ContactListener {
        @Override
        public void beginContact(Contact contact) {
            Gdx.app.log("START CONTACT", "contact user data A: " + contact.getFixtureA().getUserData().toString());
            Gdx.app.log("START CONTACT", "contact user data B: " + contact.getFixtureB().getUserData().toString());

            final String fixA = (String) contact.getFixtureA().getUserData();
            final String fixB = (String) contact.getFixtureB().getUserData();

            stage.addAction(new Action() {
                @Override
                public boolean act(float delta) {

                    if(!(fixA.split("-")[0].equalsIgnoreCase(fixB.split("-")[0]))){
                        KnightActor actA = actorMap.get(fixA);
                        KnightActor actB = actorMap.get(fixB);

                        actA.collision(true,actB.getDamage());
                        actB.collision(true,actA.getDamage());
                    }
                    return true;
                }
            });

        }

        @Override
        public void endContact(Contact contact) {
            Gdx.app.log("END CONTACT", "contact user data A: " + contact.getFixtureA().getUserData().toString());
            Gdx.app.log("END CONTACT", "contact user data B: " + contact.getFixtureB().getUserData().toString());

            final String fixA = (String) contact.getFixtureA().getUserData();
            final String fixB = (String) contact.getFixtureB().getUserData();

            stage.addAction(new Action() {
                @Override
                public boolean act(float delta) {

                    if((!fixA.split("-")[0].equalsIgnoreCase(fixB.split("-")[0]))) {
                        KnightActor actA = actorMap.get(fixA);
                        KnightActor actB = actorMap.get(fixB);

                        actA.collision(false, 0);
                        actB.collision(false, 0);
                    }
                    return true;
                }
            });
        }

        @Override
        public void preSolve(Contact contact, Manifold oldManifold) {

        }

        @Override
        public void postSolve(Contact contact, ContactImpulse impulse) {

        }
    }

}
