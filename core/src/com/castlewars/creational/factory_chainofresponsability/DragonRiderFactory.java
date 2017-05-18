package com.castlewars.creational.factory_chainofresponsability;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.actors.KnightActor;
import com.castlewars.creational.builder.DragonRiderBuilder;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class DragonRiderFactory extends ActorFactory{

    public DragonRiderFactory(double rangeStart, World world) {

        super(rangeStart,world);
        actorBuilder = new DragonRiderBuilder(world);
    }

    @Override
    public void requestBuild(double counter, Vector2 pos, String key) {
        actorBuilder.buildActor(pos, key);
        actorBuilder.buildTextures();
        actorBuilder.buildAnimations();
        actorBuilder.buildMusic();
        actorBuilder.buildExtrinsitAtributes((int )counter);

    }
}
