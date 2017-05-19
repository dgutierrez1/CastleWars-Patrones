package com.castlewars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.castlewars.CastleWars;
import com.castlewars.actors.KnightActor;
import com.castlewars.behavior.Memento.Caretaker;
import com.castlewars.behavior.Memento.Memento;
import com.castlewars.structural.Composite.CreadorMenu;
import com.castlewars.structural.Composite.MenuComponent;
import com.castlewars.structural.Composite.OptionComposite;
import com.castlewars.structural.Composite.OptionLeaf;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;


/**
 * Created by Daniel Gutierrez on 7/05/2017.
 */

public class MenuScreen extends BaseScreen {

    private Stage stage;
    private Skin skin;



    public MenuScreen(final CastleWars game) {
        super(game);



    }

    @Override
    public void setCare(Caretaker care) {
        this.care = care;
    }


    @Override
    public void show() {


        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        stage = new Stage(new FitViewport(360,640));

        CreadorMenu creador= new CreadorMenu();
        creador.crearMenu(skin,stage);

        ArrayList<TextButton> botons=creador.getBotones();
        final TextButton play=creador.GetBoton("play",botons);
        final TextButton credits=creador.GetBoton("credits",botons);
        final TextButton home=creador.GetBoton("home",botons);
        final TextButton nuevo=creador.GetBoton("Nuevo Juego",botons);
        final TextButton reanudar=creador.GetBoton("Reanudar Partida",botons);
        final TextButton contacto=creador.GetBoton("Contacto Desarrolladores",botons);
        final TextButton acercaDe=creador.GetBoton("Acerca del juego",botons);


        play.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Take me to the game screen!
                //game.setScreen(game.gameScreen);
                Gdx.app.log("VERF", "button play");

                play.remove();
                credits.remove();

                stage.addActor(nuevo);
                stage.addActor(reanudar);

//                game.setScreen(game.playScreen);

            }
        });

        credits.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button credits");
                play.remove();
                credits.remove();

                stage.addActor(contacto);
                stage.addActor(acercaDe);
            }
        });

        home.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Take me to the game screen!
                //game.setScreen(game.gameScreen);
                Gdx.app.log("VERF", "button home");

                stage.clear();
                stage.addActor(home);
                stage.addActor(play);
                stage.addActor(credits);

            }
        });

        nuevo.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button nuevo");


                stage.clear();
                game.playScreen = new PlayScreen(game);
                game.setScreen(game.playScreen);

            }
        });

        reanudar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button reanudar");

                stage.clear();


                Gdx.app.log("VERF", "tamaño care: "+care.getEstados().size());

                Memento copia= care.getMemento("pausa");

                if (copia==null){

                    //JOptionPane.showMessageDialog(null,"no hay partidas guardadas");
                    Gdx.app.log("VERF", "no hay partidas guardadas");
                    game.setScreen(game.getMenuScreen());
                }else {
                    game.playScreen.setActorMap(copia.getActorMap());

                    game.setScreen(game.playScreen);

                }




            }
        });

        contacto.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button contacto");
                stage.clear();
                Gdx.app.log("VERF", "esteban@gmail.com - elProfeta@gmail.com");
                stage.addActor(home);
            }
        });

        acercaDe.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button acercaDe");
                stage.clear();
                Gdx.app.log("VERF", "Aplicacion desarrollada para el curos de patrones de diseño");
                stage.addActor(home);
            }
        });
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.3f, 0.5f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}
