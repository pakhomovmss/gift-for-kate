package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Barrier {

    class BarrierImage {

        private int speed;
        Vector2 pos;
        Rectangle emptySpace;

        public BarrierImage(Vector2 pos) {
            this.speed = 4;
            this.pos = pos;
            emptySpace = new Rectangle(this.pos.x, this.pos.y + 100, 100, 620);
        }

        public void update() {
            pos.x -= speed;

            if (pos.x < -200) {
                pos.x = 1280;
            }

            emptySpace.x = pos.x;
        }


    }

    static BarrierImage[] barriers;
    //private String[] obstacles;
    private Texture tx;
    //private int betweenDistance;

    public Barrier() {
        tx = new Texture("box_resized.jpg");
        //obstacles = new String[] {"box_resized.jpg", "little_box_resized.jpg", "cactus_resized.png"};
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
        for (BarrierImage barrier : barriers) {
            barrier.update();
        }
    }

    public void recreate() {
        int startPos = 500;

        for (int i = 0; i < barriers.length; i++) {
            barriers[i] = new BarrierImage(new Vector2(startPos, 100));
            startPos += 500;
        }
    }
}
