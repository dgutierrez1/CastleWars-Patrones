package com.castlewars.creational.factory_chainofresponsability;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.creational.builder.DragonBuilder;
import com.castlewars.structural.flyweight.FlyweightFactory;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class DragonFactory extends ActorFactory {

    public DragonFactory(double rangeStart, World world ,FlyweightFactory flyweightFactory) {
        super(rangeStart, world, flyweightFactory);
        actorBuilder = new DragonBuilder(world);
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
