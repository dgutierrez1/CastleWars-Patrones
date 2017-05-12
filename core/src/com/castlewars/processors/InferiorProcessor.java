package com.castlewars.processors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.castlewars.Constants;
import com.castlewars.screens.BaseScreen;

/**
 * Created by Daniel Gutierrez on 8/05/2017.
 */

public class InferiorProcessor extends Processor {

    public boolean isInRegion(int screenY){
        if(((Constants.HEIGHT/2)< screenY)){
            Gdx.app.log("VERF", "INFERIOR");
            return true;
        }else{
            return false;
        }
    }
}
