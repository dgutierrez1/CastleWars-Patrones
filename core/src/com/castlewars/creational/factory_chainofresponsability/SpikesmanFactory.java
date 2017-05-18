package com.castlewars.creational.factory_chainofresponsability;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;
import com.castlewars.creational.builder.SpikesmanBuilder;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class SpikesmanFactory extends ActorFactory {

    public SpikesmanFactory(double rangeStart, World world) {
        super(rangeStart, world);
        actorBuilder =  new SpikesmanBuilder(world);
    }



    @Override
    public void requestBuild(double counter, Vector2 pos) {
        actorBuilder.buildActor(pos);
        actorBuilder.buildTextures();
        actorBuilder.buildAnimations();
        actorBuilder.buildMusic();
    }
}
