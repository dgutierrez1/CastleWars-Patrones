package com.castlewars.creational.factory_chainofresponsability;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.actors.KnightActor;
import com.castlewars.creational.builder.DragonRiderBuilder;
import com.castlewars.creational.builder.LordBuilder;
import com.castlewars.structural.flyweight.FlyweightFactory;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class LordFactory extends ActorFactory {

    public LordFactory(double rangeStart, World world, FlyweightFactory flyweightFactory) {
        super(rangeStart, world);
        actorBuilder = new LordBuilder(world, flyweightFactory);
    }

    @Override
    public void requestBuild(double counter, Vector2 pos, String key) {
        actorBuilder.buildWithFlyweight(counter, pos, key);
    }
}
