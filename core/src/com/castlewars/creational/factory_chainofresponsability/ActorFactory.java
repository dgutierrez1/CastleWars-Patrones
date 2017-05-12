package com.castlewars.creational.factory_chainofresponsability;

import com.badlogic.gdx.math.Vector2;
import com.castlewars.Constants;
import com.castlewars.actors.KnightActor;
import com.castlewars.creational.builder.ActorBuilder;

/**
 * Created by Daniel Gutierrez on 7/05/2017.
 */

public abstract class ActorFactory {

    ActorFactory nextFactory;
    ActorBuilder actorBuilder;


    protected double rangeStart;
    protected  double rangeEnd;

    public ActorFactory(double rangeStart){
        rangeStart = rangeStart * Constants.KNIGHT_SELECTION_RATIO;
        rangeEnd = (rangeStart + 1) * Constants.KNIGHT_SELECTION_RATIO;
    }

    public KnightActor createActor(double counter, Vector2 position){
        if(rangeStart < counter && counter < rangeEnd){
            return requestBuild(counter, position);
        }else{
            return nextFactory.createActor(counter, position);
        }
    }
    public abstract KnightActor requestBuild(double counter, Vector2 pos);
}
