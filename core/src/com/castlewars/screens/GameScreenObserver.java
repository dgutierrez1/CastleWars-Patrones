package com.castlewars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
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
import com.castlewars.behavior.Memento.Caretaker;
import com.castlewars.behavior.Memento.Memento;
import com.castlewars.creational.factory_chainofresponsability.ActorFactory;
import com.castlewars.creational.factory_chainofresponsability.DragonFactory;
import com.castlewars.creational.factory_chainofresponsability.DragonRiderFactory;
import com.castlewars.creational.factory_chainofresponsability.LordFactory;
import com.castlewars.creational.factory_chainofresponsability.SpikesmanFactory;
import com.castlewars.processors.InferiorProcessor;
import com.castlewars.processors.Processor;
import com.castlewars.processors.SuperiorProcessor;

import com.castlewars.structural.decorator.ComponentDecorator;
import com.castlewars.structural.flyweight.FlyweightFactory;
import com.badlogic.gdx.utils.Queue;
import com.castlewars.structural.Composite.CreadorMenu;
import com.castlewars.structural.Composite.MenuComponent;
import com.castlewars.structural.Composite.OptionComposite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
 * Created by Daniel Gutierrez on 7/05/2017.
 */

public abstract class GameScreenObserver extends BaseScreen {

    protected Stage stage;


    public static FlyweightFactory flyweightFactory;

    HashMap<String, KnightActor> superiorActorMap;
    HashMap<String, KnightActor> inferiorActorMap;

    private World world;


    HashMap<String, ComponentDecorator> actorMap;


    private Skin skin;

    Texture bg;


    public Processor superiorProcessor;
    public Processor inferiorProcessor;

    public ActorFactory factory;

    protected boolean healthDeco = false;
    protected boolean attackDeco = false;
    protected boolean speedDeco = false;


    public Memento guardarPartida(){
        return new Memento(actorMap,"pausa");
    }



    public GameScreenObserver(final CastleWars game) {
        super(game);

        world = new World(new Vector2(0, 0), true);
        world.setContactListener(new GameContactListener());

        actorMap  =  new HashMap<String, ComponentDecorator>();
        createFactories();

        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        stage = new Stage(new FitViewport(360,640));
    }

/*    public void createFactories(){

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

    }*/

    public void setActorMap(HashMap<String, ComponentDecorator> actorMap) {
        this.actorMap = actorMap;
        for (HashMap.Entry<String, ComponentDecorator> entry : actorMap.entrySet()) {
            stage.addActor((ComponentDecorator)entry.getValue());
        }
    }



    public abstract void update();

    @Override
    public void show() {
        InputMultiplexer multiplexer = new InputMultiplexer();

        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(superiorProcessor);
        multiplexer.addProcessor(inferiorProcessor);

        Gdx.input.setInputProcessor(multiplexer);

        bg = new Texture("fondo.jpg");


        CreadorMenu creador = new CreadorMenu();
        creador.crearMenuOpciones(skin, stage);

        ArrayList<TextButton> botons1 = creador.getBotonesOpciones1();
        ArrayList<TextButton> botons2 = creador.getBotonesOpciones2();

        final TextButton home1 = creador.GetBoton("Home", botons1);
        final TextButton opciones1 = creador.GetBoton("Opciones", botons1);
        final TextButton poderes1 = creador.GetBoton("Poderes", botons1);
        final TextButton pausar1 = creador.GetBoton("Pausar", botons1);
        final TextButton salir1 = creador.GetBoton("Salir", botons1);
        final TextButton shield1 = creador.GetBoton("Escudo", botons1);
        final TextButton speed1 = creador.GetBoton("Velocidad", botons1);
        final TextButton damage1 = creador.GetBoton("Ataque", botons1);

        final TextButton home2 = creador.GetBoton("Home", botons2);
        final TextButton opciones2 = creador.GetBoton("Opciones", botons2);
        final TextButton poderes2 = creador.GetBoton("Poderes", botons2);
        final TextButton pausar2 = creador.GetBoton("Pausar", botons2);
        final TextButton salir2 = creador.GetBoton("Salir", botons2);
        final TextButton shield2 = creador.GetBoton("Escudo", botons2);
        final TextButton speed2 = creador.GetBoton("Velocidad", botons2);
        final TextButton damage2 = creador.GetBoton("Ataque", botons2);

        home1.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button home1");

                shield1.remove();
                speed1.remove();
                damage1.remove();
                pausar1.remove();
                salir1.remove();

                stage.addActor(opciones1);
                stage.addActor(poderes1);

            }
        });
        opciones1.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button opciones1");

                opciones1.remove();
                poderes1.remove();

                stage.addActor(pausar1);
                stage.addActor(salir1);
            }
        });
        poderes1.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button poderes1");

                opciones1.remove();
                poderes1.remove();

                stage.addActor(shield1);
                stage.addActor(speed1);
                stage.addActor(damage1);

            }
        });
        pausar1.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button pausar1");


                Memento estado = guardarPartida();
                care.addMemento(estado);

                game.menuScreen.setCare(care);

                game.setScreen(game.getMenuScreen());

                //game.getScreen().show();


                Gdx.app.log("VERF", "memento guardado");
                Gdx.app.log("VERF", "tamano : " + care.getEstados().size());

            }
        });
        salir1.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button shield1");
                System.exit(0);

            }
        });

        shield1.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button shield1");
                resetDecorate();
                healthDeco = true;

            }
        });
        speed1.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button speed1");
                resetDecorate();
                speedDeco = true;
            }
        });
        damage1.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button damage1");
                resetDecorate();
                attackDeco = true;
            }
        });

        home2.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button home2");

                shield2.remove();
                speed2.remove();
                damage2.remove();
                pausar2.remove();
                salir2.remove();

                stage.addActor(opciones2);
                stage.addActor(poderes2);

            }
        });

        opciones2.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button opciones2");

                opciones2.remove();

                poderes2.remove();

                stage.addActor(pausar2);
                stage.addActor(salir2);
            }
        });
        poderes2.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button poderes2");

                opciones2.remove();
                poderes2.remove();

                stage.addActor(shield2);
                stage.addActor(speed2);
                stage.addActor(damage2);

            }
        });
        pausar2.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button pausar2");

                Memento estado = guardarPartida();
                care.addMemento(estado);

                game.menuScreen.setCare(care);

                game.setScreen(game.getMenuScreen());

                //game.getScreen().show();


                Gdx.app.log("VERF", "memento guardado");
                Gdx.app.log("VERF", "tamano : " + care.getEstados().size());
            }
        });
        salir2.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button salir2");
                System.exit(0);

            }
        });

        shield2.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button shield2");
                resetDecorate();

                healthDeco = true;
            }
        });
        speed2.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button speed2");
                speedDeco = true;
            }
        });
        damage2.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button damage2");
                resetDecorate();

                attackDeco = true;
            }
        });
    }

    public void createFactories(){

        flyweightFactory = new FlyweightFactory();

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

    public void resetDecorate(){
        healthDeco = false;
        attackDeco = false;
        speedDeco = false;
    }

    public void deleteFromSuperiorList(String actor){

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

        stage.getBatch().begin();
        stage.getBatch().draw(bg, 0,-100);
        stage.getBatch().end();

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
                        ComponentDecorator actA =  actorMap.get(fixA);
                        ComponentDecorator actB =  actorMap.get(fixB);

                        actA.collision(true,actB.getDamage());
                        actA.toggleAttack(true);
                        actB.collision(true,actA.getDamage());
                        actB.toggleAttack(true);

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
                        ComponentDecorator actA =  actorMap.get(fixA);
                        ComponentDecorator actB =  actorMap.get(fixB);

                        actA.collision(false, 0);
                        actA.toggleAttack(false);
                        actB.collision(false, 0);
                        actB.toggleAttack(false);
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

    public HashMap<String, ComponentDecorator> getActorMap() {
        return actorMap;
    }



}
