package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	Katya katya;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Background();
		katya = new Katya();
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		bg.render(batch);
		katya.render(batch);
		batch.end();
	}

	public void update() {
		bg.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		katya.update();
	}
}
