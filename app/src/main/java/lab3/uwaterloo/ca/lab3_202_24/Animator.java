package lab3.uwaterloo.ca.lab3_202_24;

import android.util.Log;

/**
 * Created by patri on 2017-03-05.
 */

interface Movement{
    public void setPixelX(int x);
    public void setPixelY(int y);
    public int getPixelX();
    public int getPixelY();
}

public class Animator {
    Movement contextObject;
    private int targetX, targetY;

    private float Vx, Vy;
    private float acc = (float) 2;

    Animator(Movement object){
        this.contextObject = object;
        targetX = contextObject.getPixelX();
        targetY = contextObject.getPixelY();
    }

    public void setTarget(int x, int y){
        if (Vx == 0 && Vy == 0) {
            targetX = x;
            targetY = y;
            Vx = 0;
            Vy = 0;
        }
    }

    public void tick(){
        int cx = contextObject.getPixelX();
        int cy = contextObject.getPixelY();

        int dx = targetX - cx;
        int dy = targetY - cy;

        if (dx != 0) {
            Vx += acc * (dx < 0 ? -1 : 1);
        }else{
            Vx = 0;
        }
        if (dy != 0) {
            Vy += acc * (dy < 0 ? -1 : 1);
        }else{
            Vy = 0;
        }

        if (Math.abs(dx) < Math.abs((int) (2 * Vx))){
            contextObject.setPixelX(targetX);
            Vx = 0;
        }else{
            contextObject.setPixelX((int)(cx + Vx));
        }
        
        if (Math.abs(dy) < Math.abs((int) (2 * Vy))){
            contextObject.setPixelY(targetY);
            Vy = 0;
        }else{
            contextObject.setPixelY((int)(cy + Vy));
        }
    }
}
