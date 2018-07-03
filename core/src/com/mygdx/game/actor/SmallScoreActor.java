package com.mygdx.game.actor;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import com.mygdx.game.res.Res;

/**
 * 小数字分数显示
 * 
 * @xietansheng
 */
public class SmallScoreActor extends NumGroup {

    public SmallScoreActor(com.mygdx.game.MyGdxGame mainGame) {
        super(mainGame);
        Array<TextureAtlas.AtlasRegion> regions = mainGame.getAtlas().findRegions(Res.Atlas.IMAGE_NUM_SCORE_00_TO_09);
        TextureRegion[] digitRegions = new TextureRegion[regions.size];
        for (int i = 0; i < regions.size; i++) {
            digitRegions[i] = regions.get(i);
        }
        setDigitRegions(digitRegions);
    }

}



















