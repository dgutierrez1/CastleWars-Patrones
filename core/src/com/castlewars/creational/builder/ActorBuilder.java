package com.castlewars.creational.builder;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public abstract class ActorBuilder {

    protected World world;

    public ActorBuilder(World world){
        this.world = world;
    }
    protected KnightActor actor;

    public abstract void buildActor(Vector2 position, String key);
    public abstract void buildAnimations();
    public abstract void buildMusic();
    public abstract void buildTextures();
    public  void buildExtrinsitAtributes(int counter){
        actor.buildExtrinsicAtributtes(counter);
    }

    public void setDirection(float speed){
        actor.setSpeed(speed);
    }
    public KnightActor getActor(){
        return actor;
    }
}
