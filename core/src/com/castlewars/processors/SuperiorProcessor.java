package com.castlewars.processors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.castlewars.CastleWars;
import com.castlewars.Constants;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class SuperiorProcessor extends Processor {


    public boolean isInRegion(int screenY){
        if(((Constants.HEIGHT/2)> screenY)){
            Gdx.app.log("VERF", "SUPERIOR");
            return true;
        }else{
            return false;
        }
    }
}
