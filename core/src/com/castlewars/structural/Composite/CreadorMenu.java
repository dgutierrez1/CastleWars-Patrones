package com.castlewars.structural.Composite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Esteban Aguirre on 18/05/2017.
 */

public class CreadorMenu {

private ArrayList<TextButton> botones;

    public void crearMenu(MenuComponent menu, Skin skin, Stage stage){


        botones= new ArrayList<TextButton>();
        //creacion menu principal
        final MenuComponent menuPlay= new OptionComposite("play",skin);
        final MenuComponent menuCredits= new OptionComposite("credits",skin);
        final MenuComponent optionHome=new OptionLeaf("home",skin);

        menu.addComponente(menuPlay);
        menu.addComponente(menuCredits);
        menu.addComponente(optionHome);

        final TextButton play=menuPlay.getButton();
        final TextButton credits=menuCredits.getButton();
        final TextButton home=optionHome.getButton();

        play.setPosition(0, 0);
        credits.setPosition(200, 0);
        home.setPosition(100, 0);

        play.setSize(100, 300);
        credits.setSize(100, 300);
        home.setSize(100, 300);


        //creacion menu play
        MenuComponent optionNuevoJuego=new OptionLeaf("Nuevo Juego",skin);
        MenuComponent optionReanudar=new OptionLeaf("Reanudar Partida",skin);

        menuPlay.addComponente(optionNuevoJuego);
        menuPlay.addComponente(optionReanudar);


        final TextButton nuevo=optionNuevoJuego.getButton();
        final TextButton reanudar=optionReanudar.getButton();

        nuevo.setPosition(400, 0);
        reanudar.setPosition(200, 0);
        nuevo.setSize(100, 300);
        reanudar.setSize(100, 300);


        //creacion menu creditos
        MenuComponent optionContacto=new OptionLeaf("Contacto Desarrolladores",skin);
        MenuComponent optionAcercaDe=new OptionLeaf("Acerca del juego",skin);

        menuCredits.addComponente(optionContacto);
        menuCredits.addComponente(optionAcercaDe);


        final TextButton contacto=optionContacto.getButton();
        final TextButton acercaDe=optionAcercaDe.getButton();

        contacto.setPosition(400, 0);
        acercaDe.setPosition(200, 0);
        acercaDe.setSize(100, 300);
        contacto.setSize(100, 300);

        stage.addActor(play);
        stage.addActor(credits);
        stage.addActor(home);
        //stage.addActor(nuevo);
        //stage.addActor(reanudar);
        //stage.addActor(contacto);
        //stage.addActor(acercaDe);


        botones.add(play);
        botones.add(credits);
        botones.add(home);
        botones.add(nuevo);
        botones.add(reanudar);
        botones.add(contacto);
        botones.add(acercaDe);

    }

    public TextButton GetBoton(String nombre){

        TextButton boton=null;

        for (TextButton bot: botones) {
            //Gdx.app.log("VERF", nombre);
            if(bot.getText().toString().equals(nombre)){
                boton=bot;
                break;
            }
        }
       // Gdx.app.log("VERF", boton.);
        return boton;
    }




}
