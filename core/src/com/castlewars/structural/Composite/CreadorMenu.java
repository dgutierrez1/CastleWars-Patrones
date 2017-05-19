package com.castlewars.structural.Composite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.castlewars.Constants;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Esteban Aguirre on 18/05/2017.
 */

public class CreadorMenu {

private ArrayList<TextButton> botones;

    private ArrayList<TextButton> botonesOpciones1;
    private ArrayList<TextButton> botonesOpciones2;

    public void crearMenuOpciones(Skin skin, Stage stage){

        MenuComponent menu= new OptionComposite();

        botonesOpciones1= new ArrayList<TextButton>();
        botonesOpciones2= new ArrayList<TextButton>();

        MenuComponent menu1= new OptionComposite();
        MenuComponent menu2= new OptionComposite();

        menu.addComponente(menu1);
        menu.addComponente(menu2);

        MenuComponent menuOpciones1 = new OptionComposite("Opciones",skin);
        MenuComponent menuPoderes1=new OptionComposite("Poderes",skin);
        MenuComponent opcionHome1= new OptionLeaf("Home",skin);

        MenuComponent menuOpciones2 = new OptionComposite("Opciones",skin);
        MenuComponent menuPoderes2=new OptionComposite("Poderes",skin);
        MenuComponent opcionHome2= new OptionLeaf("Home",skin);

        menu1.addComponente(menuOpciones1);
        menu1.addComponente(menuPoderes1);
        menu1.addComponente(opcionHome1);

        menu2.addComponente(menuOpciones2);
        menu2.addComponente(menuPoderes2);
        menu2.addComponente(opcionHome2);

        MenuComponent optionPause1=new OptionLeaf("Pausar",skin);
        MenuComponent optionExit1=new OptionLeaf("Salir",skin);
        MenuComponent optionShield1=new OptionLeaf("Escudo",skin);
        MenuComponent optionSpeed1=new OptionLeaf("Velocidad",skin);
        MenuComponent optionDamage1=new OptionLeaf("Ataque",skin);

        menuOpciones1.addComponente(optionPause1);
        menuOpciones1.addComponente(optionExit1);

        menuPoderes1.addComponente(optionShield1);
        menuPoderes1.addComponente(optionSpeed1);
        menuPoderes1.addComponente(optionDamage1);

        MenuComponent optionPause2=new OptionLeaf("Pausar",skin);
        MenuComponent optionExit2=new OptionLeaf("Salir",skin);
        MenuComponent optionShield2=new OptionLeaf("Escudo",skin);
        MenuComponent optionSpeed2=new OptionLeaf("Velocidad",skin);
        MenuComponent optionDamage2=new OptionLeaf("Ataque",skin);


        menuOpciones2.addComponente(optionPause2);
        menuOpciones2.addComponente(optionExit2);
        menuPoderes2.addComponente(optionShield2);
        menuPoderes2.addComponente(optionSpeed2);
        menuPoderes2.addComponente(optionDamage2);

        TextButton opciones1=menuOpciones1.getButton();
        TextButton poderes1=menuPoderes1.getButton();

        TextButton salir1=optionExit1.getButton();
        TextButton pausar1=optionPause1.getButton();

        TextButton shield1=optionShield1.getButton();
        TextButton speed1=optionSpeed1.getButton();
        TextButton damage1=optionDamage1.getButton();


        TextButton opciones2=menuOpciones2.getButton();
        TextButton poderes2=menuPoderes2.getButton();

        TextButton salir2=optionExit2.getButton();
        TextButton pausar2=optionPause2.getButton();

        TextButton shield2=optionShield2.getButton();
        TextButton speed2=optionSpeed2.getButton();
        TextButton damage2=optionDamage2.getButton();

        TextButton home1=opcionHome1.getButton();
        TextButton home2=opcionHome2.getButton();


        home1.setSize(home1.getWidth(),100);
        opciones1.setSize(opciones1.getWidth(),100);
        poderes1.setSize(poderes1.getWidth(),100);

        pausar1.setSize(pausar1.getWidth(),100);
        salir1.setSize(salir1.getWidth(),100);

        shield1.setSize(shield1.getWidth(),100);
        speed1.setSize(speed1.getWidth(),100);
        damage1.setSize(damage1.getWidth(),100);


        home1.setPosition(0,0);
        opciones1.setPosition(100, 0);
        poderes1.setPosition(200, 0);

        pausar1.setPosition(100, 0);
        salir1.setPosition(200, 0);

        shield1.setPosition(100, 0);
        speed1.setPosition(200, 0);
        damage1.setPosition(270, 0);



        home2.setSize(home2.getWidth(),100);
        opciones2.setSize(opciones2.getWidth(),100);
        poderes2.setSize(poderes2.getWidth(),100);

        pausar2.setSize(pausar2.getWidth(),100);
        salir2.setSize(salir2.getWidth(),100);

        shield2.setSize(shield2.getWidth(),100);
        speed2.setSize(speed2.getWidth(),100);
        damage2.setSize(damage2.getWidth(),100);

        home2.setPosition(0,Constants.HEIGHT-home2.getHeight());
        opciones2.setPosition(100, Constants.HEIGHT-opciones2.getHeight());
        poderes2.setPosition(200, Constants.HEIGHT-poderes2.getHeight());

        pausar2.setPosition(100, Constants.HEIGHT-pausar2.getHeight());
        salir2.setPosition(200, Constants.HEIGHT-salir2.getHeight());

        shield2.setPosition(100, Constants.HEIGHT-shield2.getHeight());
        speed2.setPosition(200, Constants.HEIGHT-speed2.getHeight());
        damage2.setPosition(270, Constants.HEIGHT-damage2.getHeight());


        stage.addActor(opciones1);
        stage.addActor(poderes1);
        stage.addActor(home1);
        stage.addActor(opciones2);
        stage.addActor(poderes2);
        stage.addActor(home2);

        botonesOpciones1.add(opciones1);
        botonesOpciones1.add(poderes1);
        botonesOpciones1.add(home1);
        botonesOpciones1.add(pausar1);
        botonesOpciones1.add(salir1);
        botonesOpciones1.add(shield1);
        botonesOpciones1.add(speed1);
        botonesOpciones1.add(damage1);



        botonesOpciones2.add(opciones2);
        botonesOpciones2.add(poderes2);
        botonesOpciones2.add(home2);
        botonesOpciones2.add(pausar2);
        botonesOpciones2.add(salir2);
        botonesOpciones2.add(shield2);
        botonesOpciones2.add(speed2);
        botonesOpciones2.add(damage2);
    }


    public void crearMenu(Skin skin, Stage stage){


        botones= new ArrayList<TextButton>();
        //creacion menu principal
        MenuComponent menu= new OptionComposite();


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
        credits.setPosition(200, 0);
        home.setPosition(0, 0);

        play.setSize(play.getWidth(),100);
        credits.setSize(credits.getWidth(),100);
        home.setSize(home.getWidth(),100);





        //creacion menu play
        MenuComponent optionNuevoJuego=new OptionLeaf("Nuevo Juego",skin);
        MenuComponent optionReanudar=new OptionLeaf("Reanudar Partida",skin);

        menuPlay.addComponente(optionNuevoJuego);
        menuPlay.addComponente(optionReanudar);


        final TextButton nuevo=optionNuevoJuego.getButton();
        final TextButton reanudar=optionReanudar.getButton();

        nuevo.setPosition(50, 0);
        reanudar.setPosition(200, 0);

        nuevo.setSize(nuevo.getWidth(),100);
        reanudar.setSize(reanudar.getWidth(),100);


        //creacion menu creditos
        MenuComponent optionContacto=new OptionLeaf("Contacto Desarrolladores",skin);
        MenuComponent optionAcercaDe=new OptionLeaf("Acerca del juego",skin);

        menuCredits.addComponente(optionContacto);
        menuCredits.addComponente(optionAcercaDe);


        final TextButton contacto=optionContacto.getButton();
        final TextButton acercaDe=optionAcercaDe.getButton();

        contacto.setPosition(50, 0);
        acercaDe.setPosition(250, 0);

        contacto.setSize(contacto.getWidth(),100);
        acercaDe.setSize(acercaDe.getWidth(),100);

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

    public ArrayList<TextButton> getBotones() {
        return botones;
    }

    public void setBotones(ArrayList<TextButton> botones) {
        this.botones = botones;
    }

    public ArrayList<TextButton> getBotonesOpciones1() {
        return botonesOpciones1;
    }

    public void setBotonesOpciones1(ArrayList<TextButton> botonesOpciones1) {
        this.botonesOpciones1 = botonesOpciones1;
    }

    public ArrayList<TextButton> getBotonesOpciones2() {
        return botonesOpciones2;
    }

    public void setBotonesOpciones2(ArrayList<TextButton> botonesOpciones2) {
        this.botonesOpciones2 = botonesOpciones2;
    }
}
