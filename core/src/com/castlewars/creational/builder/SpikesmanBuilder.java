package com.castlewars.creational.builder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.actors.KnightActor;
import com.castlewars.actors.SpikesmanActor;
import com.castlewars.actors.animations.Animation;
import com.castlewars.screens.GameScreenObserver;
import com.castlewars.structural.flyweight.FlyweightFactory;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class SpikesmanBuilder extends ActorBuilder {


    public SpikesmanBuilder(World world, FlyweightFactory flyweightFactory) {
        super(world, flyweightFactory);
    }

    @Override
    public void buildActor() {
        actor = new SpikesmanActor();
        actor.setWord(world);
        Gdx.app.log("CREATION", "Spikesman");
    }

    @Override
    public void buildAnimations() {
        actor.setWalkAnimation(new Animation(new Texture("lvl1_spikesman_animation.png"), 4, 0.5f));
        actor.setAttackAnimation(new Animation(new Texture("lvl1_spikesmanattack_animation.png"), 10, 1.625f));
        actor.setAnimation(actor.getWalkAnimation());
    }

    @Override
    public void buildMusic() {
        actor.setSound(Gdx.audio.newSound(Gdx.files.internal("lvl1.wav")));
    }

    @Override
    public void buildWithFlyweight(double counter, Vector2 position, String key) {
        actor = GameScreenObserver.flyweightFactory.getActor("spikesman", this);
        buildExtrinsitAtributes(counter, position, key);
    }


}
