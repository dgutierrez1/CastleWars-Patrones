package com.castlewars.creational.builder;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;
import com.castlewars.structural.flyweight.FlyweightFactory;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public abstract class ActorBuilder {

    protected World world;
    //ublic FlyweightFactory flyweightFactory;

    public ActorBuilder(World world, FlyweightFactory flyweightFactory){
        this.world = world;
        //this.flyweightFactory = flyweightFactory;
    }
    protected KnightActor actor;

    public abstract void buildActor();
    public abstract void buildAnimations();
    public abstract void buildMusic();
    public abstract void  buildWithFlyweight(double counter, Vector2 position, String key);
    public  void buildExtrinsitAtributes(double counter, Vector2 position, String key){
        actor.buildExtrinsicAtributtes(counter, position,key);
    }

    public void setDirection(float speed){
        actor.setSpeed(speed);
    }
    public KnightActor getActor(){
        return actor;
    }
}
