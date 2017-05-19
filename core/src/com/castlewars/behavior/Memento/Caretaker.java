package com.castlewars.behavior.Memento;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by Esteban Aguirre on 18/05/2017.
 */

public class Caretaker {

    private ArrayList<Memento> estados= new ArrayList<Memento>();


    public void addMemento(Memento memento){
        estados.add(memento);

        Gdx.app.log("VERF", "agregado: "+memento.getNombre());
        Gdx.app.log("VERF", "tamano: "+estados.size());
    }

    public ArrayList<Memento> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Memento> estados) {
        this.estados = estados;
    }

    public Memento getMemento(String nombre){

        Memento memen=null;
        for (Memento estad: estados) {

            if(estad.getNombre().equals(nombre)){
                memen=estad;
                break;
            }
        }


        return memen;
    }



}
