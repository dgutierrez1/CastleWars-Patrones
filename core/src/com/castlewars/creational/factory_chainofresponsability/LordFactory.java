package com.castlewars.creational.factory_chainofresponsability;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.actors.KnightActor;
import com.castlewars.creational.builder.DragonRiderBuilder;
import com.castlewars.creational.builder.LordBuilder;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class LordFactory extends ActorFactory {

    public LordFactory(double rangeStart, World world) {
        super(rangeStart, world);
        actorBuilder = new LordBuilder(world);
    }

    @Override
    public KnightActor requestBuild(double counter, Vector2 pos) {
        actorBuilder.buildActor(pos);
        actorBuilder.buildTextures();
        actorBuilder.buildAnimations();
        actorBuilder.buildMusic();
        return actorBuilder.getActor();
    }
}
