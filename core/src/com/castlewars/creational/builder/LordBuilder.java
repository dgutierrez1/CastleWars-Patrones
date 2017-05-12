package com.castlewars.creational.builder;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.actors.LordActor;
import com.castlewars.actors.KnightActor;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class LordBuilder extends ActorBuilder {


    public LordBuilder(World world) {
        super(world);
    }

    @Override
    public void buildActor(Vector2 pos) {
        //actor = new LordActor(world, pos);
    }

    @Override
    public void buildAnimations() {

    }

    @Override
    public void buildMusic() {

    }

    @Override
    public void buildTextures() {

    }

    @Override
    public KnightActor getActor() {
        return null;
    }
}
