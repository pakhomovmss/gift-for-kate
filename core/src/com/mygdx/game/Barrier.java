package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Barrier {

    class BarrierImage {

        private Texture tx;
        private Vector2 pos;

        public BarrierImage(Vector2 pos) {
            this.tx = new Texture("cactus300x300.png");
            this.pos = pos;
        }

    }

    private BarrierImage[] barriers = new BarrierImage[4];
    private int speed;

    public Barrier() {
        for (int i = 0; i < 4; i++) {
            this.barriers[i] = new BarrierImage(new Vector2((i + 1) * 500, 100));
        }

        this.speed = 4;
    }

    public void render(SpriteBatch batch) {
        for(BarrierImage barrier : barriers) {
            batch.draw(barrier.tx, barrier.pos.x, barrier.pos.y);
        }
    }

    public void update() {
        for(BarrierImage barrier : barriers) {
            barrier.pos.x -= speed;
        }

        if (barriers[2].pos.x <= 500) {
            for (int i = 0; i < barriers.length; i++) {
                barriers[i].pos.x = (i + 1) * 500;
            }
        }
    }
}
