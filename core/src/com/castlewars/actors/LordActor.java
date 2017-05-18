package com.castlewars.actors;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class LordActor extends KnightActor {

    public LordActor() {


    }

    @Override
    public double getDamage() {
        return 30;
    }


    @Override
    public double getSpeed() {
        return 20;
    }

    @Override
    public double getShield() {
        return 100;
    }



}
