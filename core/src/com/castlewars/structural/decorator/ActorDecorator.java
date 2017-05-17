package com.castlewars.structural.decorator;

import com.castlewars.actors.KnightActor;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public abstract class ActorDecorator extends ComponentDecorator {

protected ComponentDecorator decorable;


    public ActorDecorator(ComponentDecorator decorable) {

        this.decorable = decorable;
    }

    public ComponentDecorator getDecorable() {

        return decorable;
    }

    public void setDecorable(ComponentDecorator decorable) {

        this.decorable = decorable;
    }

    @Override
    public String mostrarCaracteristicas() {
        return null;
    }

}
