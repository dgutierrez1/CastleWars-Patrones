package com.castlewars.screens;

import com.badlogic.gdx.Gdx;
import com.castlewars.CastleWars;
import com.castlewars.actors.LordActor;
import com.castlewars.structural.decorator.ActorDecorator;
import com.castlewars.processors.InferiorProcessor;
import com.castlewars.processors.Processor;
import com.castlewars.processors.SuperiorProcessor;
import com.castlewars.structural.decorator.AttackDecorator;
import com.castlewars.structural.decorator.ComponentDecorator;
import com.castlewars.structural.decorator.ShieldDecorator;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class PlayScreen extends GameScreenObserver {

    private int superiorCounter = 0;
    private boolean superiorPress = false;
    private boolean superiorPressed = false;

    private int inferiorCounter = 0;
    private boolean inferiorPress = false;
    private boolean inferiorPressed = false;

    public PlayScreen(CastleWars game) {
        super(game);

        this.superiorProcessor = new SuperiorProcessor();
        this.inferiorProcessor = new InferiorProcessor();
        superiorProcessor.attachObserver(this);
        inferiorProcessor.attachObserver(this);
    }

    @Override
    public void update() {
        superiorPressed = superiorProcessor.getPressed();
        superiorPress = superiorProcessor.getState();

        inferiorPressed = inferiorProcessor.getPressed();
        inferiorPress = inferiorProcessor.getState();
    }
    public void accumulate(){

        if(superiorPressed){
            if(superiorPress){
                superiorCounter++;
            }else{
                if(superiorCounter>0){
                    Gdx.app.log("DEPLOY", "SOLDIER WITH superior" +superiorCounter);
                    ComponentDecorator soldado= new LordActor();
                    Gdx.app.log("DEPLOY", "escudo normal"+soldado.getShield());
                    soldado= new ShieldDecorator(soldado);
                    //soldado= new AttackDecorator(soldado);

                    Gdx.app.log("DEPLOY", "caracteristitcas soldado");
                    Gdx.app.log("DEPLOY", "escudo"+soldado.getShield());
                    Gdx.app.log("DEPLOY", "ataque"+soldado.getAttack());
                    superiorCounter = 0;
                }
                superiorPressed = false;

            }
        }

        if(inferiorPressed){
            if(inferiorPress){
                inferiorCounter++;
            }else{
                if(inferiorCounter> 0){
                    Gdx.app.log("DEPLOY", "SOLDIER inferior" +inferiorCounter);

                    inferiorCounter = 0;
                }
                inferiorPressed = false;
            }
        }

    }


}
