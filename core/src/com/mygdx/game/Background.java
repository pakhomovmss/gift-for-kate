package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {

    class BackgroundPicture {
        private Texture tx;
        private Vector2 pos;

        public BackgroundPicture(Vector2 pos) {
            tx = new Texture("maxresdefault.jpg");
            this.pos = pos;
        }
    }

    private BackgroundPicture[] backgrounds;
    private int speed;

    public Background() {
        backgrounds = new BackgroundPicture[2];
        backgrounds[0] = new BackgroundPicture(new Vector2(0, 0));
        backgrounds[1] = new BackgroundPicture(new Vector2(1280, 0));
        speed = 4;
    }

    public void render(SpriteBatch batch) {
        for(BackgroundPicture bgPicture : backgrounds) {
            batch.draw(bgPicture.tx, bgPicture.pos.x, bgPicture.pos.y);
        }
    }

    public void update() {
        for(BackgroundPicture bgPicture : backgrounds) {
            bgPicture.pos.x -= speed;
        }

        if (backgrounds[0].pos.x < -1280) {
            backgrounds[0].pos.x = 0;
            backgrounds[1].pos.x = 1280;
        }
    }
}
