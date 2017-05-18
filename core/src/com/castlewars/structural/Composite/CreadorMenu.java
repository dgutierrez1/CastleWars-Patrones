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
    private ArrayList<TextButton> botonesPoderes1;
    private ArrayList<TextButton> botonesPoderes2;

    public void crearMenuPoderes(MenuComponent menu1,MenuComponent menu2, Skin skin, Stage stage){

        botonesPoderes1= new ArrayList<TextButton>();
        botonesPoderes2= new ArrayList<TextButton>();

        MenuComponent optionShield1=new OptionLeaf("Escudo",skin);
        MenuComponent optionSpeed1=new OptionLeaf("Velocidad",skin);
        MenuComponent optionDamage1=new OptionLeaf("Daño",skin);

        menu1.addComponente(optionShield1);
        menu1.addComponente(optionSpeed1);
        menu1.addComponente(optionDamage1);

        MenuComponent optionShield2=new OptionLeaf("Escudo",skin);
        MenuComponent optionSpeed2=new OptionLeaf("Velocidad",skin);
        MenuComponent optionDamage2=new OptionLeaf("Daño",skin);

        menu2.addComponente(optionShield2);
        menu2.addComponente(optionSpeed2);
        menu2.addComponente(optionDamage2);


        TextButton shield1=optionShield1.getButton();
        TextButton speed1=optionSpeed1.getButton();
        TextButton damage1=optionDamage1.getButton();

        TextButton shield2=optionShield2.getButton();
        TextButton speed2=optionSpeed2.getButton();
        TextButton damage2=optionDamage2.getButton();


        shield1.setPosition(0, 0);
        speed1.setPosition(300, 0);
        damage1.setPosition(600, 0);
        shield2.setPosition(0, 300);
        speed2.setPosition(300, 300);
        damage2.setPosition(600, 300);

        shield1.setSize(200, 200);
        speed1.setSize(200, 200);
        damage1.setSize(200, 200);
        shield2.setSize(200, 200);
        speed2.setSize(200, 200);
        damage2.setSize(200, 200);


        stage.addActor(shield1);
        stage.addActor(speed1);
        stage.addActor(damage1);
        stage.addActor(shield2);
        stage.addActor(speed2);
        stage.addActor(damage2);

        botonesPoderes1.add(shield1);
        botonesPoderes1.add(speed1);
        botonesPoderes1.add(damage1);
        botonesPoderes2.add(shield2);
        botonesPoderes2.add(speed2);
        botonesPoderes2.add(damage2);
    }


    public void crearMenu(MenuComponent menu, Skin skin, Stage stage){


        botones= new ArrayList<TextButton>();
        //creacion menu principal
        MenuComponent menuPlay= new OptionComposite("play",skin);
        MenuComponent menuCredits= new OptionComposite("credits",skin);
        MenuComponent optionHome=new OptionLeaf("home",skin);

        menu.addComponente(menuPlay);
        menu.addComponente(menuCredits);
        menu.addComponente(optionHome);

        TextButton play=menuPlay.getButton();
        TextButton credits=menuCredits.getButton();
        TextButton home=optionHome.getButton();

        play.setPosition(100, 0);
        credits.setPosition(300, 0);
        home.setPosition(0, 0);

        play.setSize(200, 200);
        credits.setSize(200, 200);
        home.setSize(100, 200);


        //creacion menu play
        MenuComponent optionNuevoJuego=new OptionLeaf("Nuevo Juego",skin);
        MenuComponent optionReanudar=new OptionLeaf("Reanudar Partida",skin);

        menuPlay.addComponente(optionNuevoJuego);
        menuPlay.addComponente(optionReanudar);


        final TextButton nuevo=optionNuevoJuego.getButton();
        final TextButton reanudar=optionReanudar.getButton();

        nuevo.setPosition(100, 0);
        reanudar.setPosition(300, 0);
        nuevo.setSize(200, 200);
        reanudar.setSize(200, 200);


        //creacion menu creditos
        MenuComponent optionContacto=new OptionLeaf("Contacto Desarrolladores",skin);
        MenuComponent optionAcercaDe=new OptionLeaf("Acerca del juego",skin);

        menuCredits.addComponente(optionContacto);
        menuCredits.addComponente(optionAcercaDe);


        final TextButton contacto=optionContacto.getButton();
        final TextButton acercaDe=optionAcercaDe.getButton();

        contacto.setPosition(100, 0);
        acercaDe.setPosition(300, 0);
        acercaDe.setSize(200, 200);
        contacto.setSize(200, 200);

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

    public TextButton GetBoton(String nombre,ArrayList<TextButton> botons){

        TextButton boton=null;

        for (TextButton bot: botons) {
            //Gdx.app.log("VERF", nombre);
            if(bot.getText().toString().equals(nombre)){
                boton=bot;
                break;
            }
        }
       // Gdx.app.log("VERF", boton.);
        return boton;
    }

    public ArrayList<TextButton> getBotonesPoderes1() {
        return botonesPoderes1;
    }

    public void setBotonesPoderes1(ArrayList<TextButton> botonesPoderes1) {
        this.botonesPoderes1 = botonesPoderes1;
    }

    public ArrayList<TextButton> getBotonesPoderes2() {
        return botonesPoderes2;
    }

    public void setBotonesPoderes2(ArrayList<TextButton> botonesPoderes2) {
        this.botonesPoderes2 = botonesPoderes2;
    }

    public ArrayList<TextButton> getBotones() {
        return botones;
    }

    public void setBotones(ArrayList<TextButton> botones) {
        this.botones = botones;
    }
}
