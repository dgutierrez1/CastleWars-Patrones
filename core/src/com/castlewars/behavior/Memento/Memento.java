package com.castlewars.behavior.Memento;

import com.castlewars.actors.KnightActor;

import java.util.HashMap;

/**
 * Created by Esteban Aguirre on 18/05/2017.
 */

public class Memento {


    HashMap<String, KnightActor> actorMap;
    private  String nombre;

    public Memento(HashMap<String, KnightActor> actorMap,String nombre) {
        this.actorMap = actorMap;
        this.nombre=nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, KnightActor> getActorMap() {
        return actorMap;
    }

    public void setActorMap(HashMap<String, KnightActor> actorMap) {
        this.actorMap = actorMap;
    }
}
