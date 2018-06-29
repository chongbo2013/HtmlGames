package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

//https://github.com/libgdx/libgdx/wiki/Interfacing-with-platform-specific-code
public class MyGdxGame extends ApplicationAdapter {

	Texture img;
	Stage stage;
	JsniTest jsniTest=new JsniTest();
	@Override
	public void create () {

		img = new Texture("badlogic.jpg");
		stage=new Stage();
		Image image=new Image(img);
		stage.addActor(image);
		JsniTest.registerGlobalGwtJsMethods();
		image.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				jsniTest.alert("java call Js");
			}
		});

		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(inputMultiplexer);

	}
	float delta=0;
	@Override
	public void render () {
		 delta+=Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(1, 1,1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {

		img.dispose();
		stage.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		stage.getViewport().setScreenSize(width,height);
	}
}
