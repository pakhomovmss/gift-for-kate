package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Katya {
    Texture imgRun;
    Vector2 pos;
    float velocity;
    float gravity;

    public Katya() {
        imgRun = new Texture("KatyaRun1_resized_copy.png");
        pos = new Vector2(200, 100);
        velocity = 0;
        gravity = -0.5f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(imgRun, pos.x, pos.y);
    }

    public void update() {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
            velocity = 10;

        if (isUnderGround(pos)) {
            pos = new Vector2(200, 100);
            velocity = 0;
        }


        else {
            velocity += gravity;
            pos.y += velocity;
        }

    }

    private boolean isUnderGround(Vector2 position) {
        return pos.y < 100;
    }

    public void recreate() {
        pos = new Vector2(200, 100);
        velocity = 0;
    }
}
