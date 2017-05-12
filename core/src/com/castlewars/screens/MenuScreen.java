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



/**
 * Created by Daniel Gutierrez on 7/05/2017.
 */

public class MenuScreen extends BaseScreen {

    private Stage stage;
    private Skin skin;
    private TextButton play, options, credits, exit;

    public MenuScreen(final CastleWars game) {
        super(game);
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        stage = new Stage(new FitViewport(640, 360));

        play = new TextButton("Play", skin);
        credits = new TextButton("Credits", skin);

        play.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Take me to the game screen!
                //game.setScreen(game.gameScreen);
                Gdx.app.log("VERF", "button play");
                game.setScreen(game.playScreen);

            }
        });

        credits.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //game.setScreen(game.creditsScreen);
                Gdx.app.log("VERF", "button credits");
            }
        });

        play.setSize(200, 80);
        credits.setSize(200, 80);
        play.setPosition(40, 140);
        credits.setPosition(40, 40);


        stage.addActor(play);
        stage.addActor(credits);

    }

    @Override
    public void show() {
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
