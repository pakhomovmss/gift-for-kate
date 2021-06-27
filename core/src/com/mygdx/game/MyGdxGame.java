package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	Katya katya;
	Barrier barrier;
	boolean isGameOver;
	Texture replay;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Background();
		katya = new Katya();
		barrier = new Barrier();
		isGameOver = false;
		replay = new Texture("Replay.png");
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		bg.render(batch);
		barrier.render(batch);
		if (!isGameOver) {
			katya.render(batch);
		}
		else {
			batch.draw(replay, 425, 285);
		}
		batch.end();
	}

	public void update() {
		bg.update();
		barrier.update();
		katya.update();

		for (int i = 0; i < Barrier.barriers.length; i++) {
			if (katya.pos.x > Barrier.barriers[i].pos.x && katya.pos.x < Barrier.barriers[i].pos.x + 100) {
				if (!Barrier.barriers[i].emptySpace.contains(katya.pos)) {
					isGameOver = true;

				}
			}
		}

		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && isGameOver) {
			recreate();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//katya.update();
	}

	public void recreate() {
		katya.recreate();
		barrier.recreate();
		isGameOver = false;
	}
}
