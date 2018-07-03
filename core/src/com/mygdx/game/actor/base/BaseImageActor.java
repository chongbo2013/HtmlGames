package com.mygdx.game.actor.base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actor.framework.ImageActor;

/**
 * 演员基类
 * 
 * @xietansheng
 */
public abstract class BaseImageActor extends ImageActor {

    private MyGdxGame mainGame;

    public BaseImageActor(MyGdxGame mainGame) {
        this.mainGame = mainGame;
    }

    public BaseImageActor(MyGdxGame mainGame, TextureRegion region) {
        super(region);
        this.mainGame = mainGame;
    }

    public MyGdxGame getMainGame() {
        return mainGame;
    }

    public void setMainGame(MyGdxGame mainGame) {
        this.mainGame = mainGame;
    }

}















