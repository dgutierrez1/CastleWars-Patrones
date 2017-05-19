package com.castlewars.creational.builder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.actors.DragonRiderActor;
import com.castlewars.actors.KnightActor;
import com.castlewars.actors.SpikesmanActor;
import com.castlewars.actors.animations.Animation;
import com.castlewars.screens.GameScreenObserver;
import com.castlewars.structural.flyweight.FlyweightFactory;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class DragonRiderBuilder extends ActorBuilder {


    public DragonRiderBuilder(World world, FlyweightFactory flyweightFactory) {
        super(world, flyweightFactory);
    }

    @Override
    public void buildActor() {
        actor = new DragonRiderActor();
        actor.setWord(world);
        Gdx.app.log("CREATION", "Dragon Rider");
    }

    @Override
    public void buildAnimations() {
        actor.setWalkAnimation(new Animation(new Texture("lvl3_dragonrider_animation.png"), 4, 0.5f));
        actor.setAttackAnimation(new Animation(new Texture("lvl3_dragonriderattack_animation.png"), 8, 1.625f));
        actor.setAnimation(actor.getWalkAnimation());

    }

    @Override
    public void buildMusic() {
        actor.setSound(Gdx.audio.newSound(Gdx.files.internal("lvl3.wav")));
    }

    @Override
    public void buildWithFlyweight(double counter, Vector2 position, String key) {
        actor = GameScreenObserver.flyweightFactory.getActor("dragonrider", this);
        buildExtrinsitAtributes(counter, position, key);
    }


}
