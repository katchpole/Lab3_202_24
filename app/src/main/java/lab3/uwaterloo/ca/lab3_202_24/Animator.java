package lab3.uwaterloo.ca.lab3_202_24;

import android.util.Pair;

/**
 * Created by patri on 2017-03-05.
 */

interface Movement{
    public void setX(int x);
    public void setY(int y);
    public int getPixelX();
    public int getPixelY();
}

public class Animator {
    Movement contextObject;
    private int targetX, targetY;
    private float ratio;

    private float Vx, Vy;
    private float acc = (float) 0.5;
    Animator(Movement object){
        this.contextObject = object;
        targetX = contextObject.getPixelX();
        targetY = contextObject.getPixelY();
        ratio = 0;
    }

    public void setTarget(int x, int y){
        targetX = x;
        targetY = y;
    }

    public void tick(){
        int cx = contextObject.getPixelX();
        int cy = contextObject.getPixelY();

        int dx = cx - targetX;
        int dy = cy - targetY;

        Vx += acc;
        Vy += acc;

        if (Math.abs(dx) < Vx){
            contextObject.setX(targetX);
            Vx = 0;
        }else{
            contextObject.setY((int)(cx + Vx));
        }
        
        if (Math.abs(dy) < Vy){
            contextObject.setY(targetY);
            Vy = 0;
        }else{
            contextObject.setY((int)(cy + Vy));
        }
    }
}
