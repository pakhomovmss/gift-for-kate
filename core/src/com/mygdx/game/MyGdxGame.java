package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	Katya katya;
	Barrier barrier;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Background();
		katya = new Katya();
		barrier = new Barrier();
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		bg.render(batch);
		barrier.render(batch);
		katya.render(batch);
		batch.end();
	}

	public void update() {
		bg.update();
		barrier.update();
		katya.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//katya.update();
	}
}
