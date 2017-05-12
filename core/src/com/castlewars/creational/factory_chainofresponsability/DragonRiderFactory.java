package com.castlewars.creational.factory_chainofresponsability;

import com.badlogic.gdx.math.Vector2;
import com.castlewars.actors.KnightActor;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class DragonRiderFactory extends ActorFactory{

    public DragonRiderFactory(double rangeStart) {
        super(rangeStart);
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
