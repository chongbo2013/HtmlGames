package com.mygdx.game.actor.base;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actor.framework.AnimationActor;

/**
 * 动画演员基类
 * 
 * @xietansheng
 */
public abstract class BaseAnimationActor extends AnimationActor {

    private MyGdxGame mainGame;

    public BaseAnimationActor(MyGdxGame mainGame) {
        this.mainGame = mainGame;
    }
    
    public BaseAnimationActor(MyGdxGame mainGame, Animation animation) {
        super(animation);
        this.mainGame = mainGame;
    }
    
    public BaseAnimationActor(MyGdxGame mainGame, float frameDuration, Array<? extends TextureRegion> keyFrames) {
		super(frameDuration, keyFrames);
		this.mainGame = mainGame;
    }

    public BaseAnimationActor(MyGdxGame mainGame, float frameDuration, TextureRegion... keyFrames) {
        super(frameDuration, keyFrames);
        this.mainGame = mainGame;
    }

    public MyGdxGame getMainGame() {
        return mainGame;
    }

    public void setMainGame(MyGdxGame mainGame) {
        this.mainGame = mainGame;
    }

}















