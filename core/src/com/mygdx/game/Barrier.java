package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Barrier {

    class BarrierImage {

        private int speed;
        private Vector2 pos;

        public BarrierImage(Vector2 pos) {
            this.speed = 4;
            this.pos = pos;
        }

        public void update() {
            pos.x -= speed;

            if (pos.x < -200) {
                pos.x = 1280;
            }
        }

    }

    private BarrierImage[] barriers;
    private Texture tx;
    //private int betweenDistance;

    public Barrier() {
        tx = new Texture("cactus_resized.png");
        barriers = new BarrierImage[3];
        int startPos = 500;
        //betweenDistance = 500;

        for (int i = 0; i < barriers.length; i++) {
            barriers[i] = new BarrierImage(new Vector2(startPos, 100));
            startPos += 500;
        }
    }

    public void render(SpriteBatch batch) {
        for (BarrierImage barrier : barriers) {
            batch.draw(tx, barrier.pos.x, barrier.pos.y);
        }
    }

    public void update() {
        for(BarrierImage barrier : barriers) {
            barrier.update();
        }

    /*
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
     */
    }
}
