package com.castlewars.structural.flyweight;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.castlewars.actors.KnightActor;
import com.castlewars.creational.builder.ActorBuilder;
import com.castlewars.creational.factory_chainofresponsability.ActorFactory;
import com.castlewars.screens.GameScreenObserver;

import java.util.HashMap;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class FlyweightFactory {

    private static final HashMap<String, KnightActor> actorMap = new HashMap();


    public KnightActor getActor(String type, ActorBuilder builder){
        KnightActor knight =  actorMap.get(type);

        if(knight == null){
            builder.buildActor();
            builder.buildAnimations();
            builder.buildMusic();
            knight = builder.getActor();
            actorMap.put(type, knight);
        }
        return (KnightActor) knight.clone();
    }

}
