package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Katya {
    Texture imgRun;
    Vector2 pos;

    public Katya() {
        imgRun = new Texture("KatyaRun1.png");
        pos = new Vector2(200, 0);
    }

    public void render(SpriteBatch batch) {
        batch.draw(imgRun, pos.x, pos.y);
    }

    public void update() {

    }
}
