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
        imgRun = new Texture("KatyaRun1.png");
        pos = new Vector2(200, 0);
        velocity = 0;
        gravity = -0.5f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(imgRun, pos.x, pos.y);
    }

    public void update() {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
            velocity = 10;
        System.out.print(pos.y);
        
        /*
        if (pos.y ) {
            velocity += gravity;
            pos.y += velocity;
        }
        */

        velocity += gravity;
        pos.y += velocity;
    }
}
