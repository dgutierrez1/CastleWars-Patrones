package com.castlewars.actors.structural.flyweight;

import com.castlewars.actors.KnightActor;
import com.castlewars.creational.factory_chainofresponsability.ActorFactory;
import com.castlewars.screens.GameScreenObserver;

import java.util.HashMap;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class FlyweightFactory {

    private static final HashMap<String, KnightActor> actorMap = new HashMap();
    private GameScreenObserver playScreen;

    public FlyweightFactory(GameScreenObserver playScreen){
        this.playScreen = playScreen;
    }

    public KnightActor getActor(String type){
        KnightActor knight = (KnightActor) actorMap.get(type);

        if(knight == null){
            //playScreen.factory.
        }
        return null;
    }

}
