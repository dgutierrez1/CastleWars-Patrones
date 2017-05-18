package com.castlewars.creational.factory_chainofresponsability;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;
import com.castlewars.creational.builder.ActorBuilder;
import com.castlewars.structural.flyweight.FlyweightFactory;

/**
 * Created by Daniel Gutierrez on 7/05/2017.
 */

public abstract class ActorFactory {

    protected ActorFactory nextFactory;
    protected ActorBuilder actorBuilder;
    protected FlyweightFactory flyweightFactory;
    protected World world;


    protected double rangeStart;
    protected  double rangeEnd;

    public ActorFactory(double rangeStart, World world){
        this.world = world;
        rangeStart = rangeStart * Constants.KNIGHT_SELECTION_RATIO;
        rangeEnd = (rangeStart + 1) * Constants.KNIGHT_SELECTION_RATIO;
    }



    /*Metodo encargado de verificar si se puede crear el objeto en esta factory, sino lo delega a la siguiente*/
    public KnightActor createActor(double counter, Vector2 position){
        if((rangeStart < counter && counter < rangeEnd) || nextFactory==null){
            return requestBuild(counter, position);
        }else{
            return nextFactory.createActor(counter, position);
        }
    }

    /*Metodo implementado en cada Factory dependiendo de lo que se requiera*/
    public abstract KnightActor requestBuild(double counter, Vector2 pos);

    public ActorFactory getNextFactory() {
        return nextFactory;
    }

    public void setNextFactory(ActorFactory nextFactory) {
        this.nextFactory = nextFactory;
    }

    public ActorBuilder getActorBuilder() {
        return actorBuilder;
    }

    public void setActorBuilder(ActorBuilder actorBuilder) {
        this.actorBuilder = actorBuilder;
    }
}
