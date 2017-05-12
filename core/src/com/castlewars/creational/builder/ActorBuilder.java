package com.castlewars.creational.builder;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.actors.KnightActor;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public abstract class ActorBuilder {
    protected World world;
    protected KnightActor actor;


    public ActorBuilder(World world){
        this.world = world;
    }
    public abstract void buildActor(Vector2 position);
    public abstract void buildAnimations();
    public abstract void buildMusic();
    public abstract void buildTextures();
    public abstract KnightActor getActor();
}
