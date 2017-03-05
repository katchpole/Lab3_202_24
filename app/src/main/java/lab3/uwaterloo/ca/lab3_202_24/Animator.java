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
    private float ratio;

    private float Vx, Vy;
    private float acc = (float) 0.5;

    private float lastDx, lastDy;
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

        Log.d("CX", String.format("%d %d", cx, targetX));
        int dx = targetX - cy;
        int dy = targetY - cy;

        Vx += acc * dx/Math.abs(dx);
        Vy += acc * dy/Math.abs(dy);

        if (Math.abs(dx) < Math.abs(Vx) || (dx < 0) != (lastDx < 0)){
            contextObject.setPixelX(targetX);
            Vx = 0;
        }else{
            contextObject.setPixelX((int)(cx + Vx));
        }
        
        if (Math.abs(dy) < Math.abs(Vy) || (dy < 0) != (lastDy < 0)){
            contextObject.setPixelY(targetY);
            Vy = 0;
        }else{
            contextObject.setPixelY((int)(cy + Vy));
        }

        lastDx = dx;
        lastDy = dy;
    }
}
