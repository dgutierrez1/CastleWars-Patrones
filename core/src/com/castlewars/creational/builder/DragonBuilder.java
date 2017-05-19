package com.castlewars.creational.builder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.actors.DragonActor;
import com.castlewars.actors.KnightActor;
import com.castlewars.actors.SpikesmanActor;
import com.castlewars.actors.animations.Animation;
import com.castlewars.screens.GameScreenObserver;
import com.castlewars.structural.flyweight.FlyweightFactory;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class DragonBuilder extends ActorBuilder {


    public DragonBuilder(World world, FlyweightFactory flyweightFactory) {
        super(world, flyweightFactory);
    }

    @Override
    public void buildActor() {
        actor = new DragonActor();
        actor.setWord(world);
        Gdx.app.log("CREATION", "Dragon");
    }
    @Override
    public void buildAnimations() {
        actor.setWalkAnimation(new Animation(new Texture("lvl4_dragon_animation.png"), 4, 0.5f));
        actor.setAttackAnimation(new Animation(new Texture("lvl4_dragonattack_animation.png"), 10, 1.625f));
        actor.setAnimation(actor.getWalkAnimation());
    }

    @Override
    public void buildMusic() {
        actor.setSound(Gdx.audio.newSound(Gdx.files.internal("lvl4.wav")));
    }

    @Override
    public void buildWithFlyweight(double counter, Vector2 position, String key) {
        actor = GameScreenObserver.flyweightFactory.getActor("dragon", this);
        buildExtrinsitAtributes(counter, position, key);
    }

}
