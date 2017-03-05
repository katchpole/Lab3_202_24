package lab3.uwaterloo.ca.lab3_202_24;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Alex on 2017-03-05.
 */

public class GameBlock extends ImageView implements Movement {



    private float IMAGE_SCALE = 0.5f;       //custom scaling to fit image into background grid
    private int myCoordX = 0;
    private int myCoordY = 0;



    public GameBlock(Context myContext, int coordX, int coordY) {
        super(myContext);
        this.setImageResource(R.drawable.gameblock);




        this.setScaleX(IMAGE_SCALE);
        this.setScaleY(IMAGE_SCALE);





        setPixelX(coordX);     //Offset to match image coord to background(0,0) is actually (-69, -69)
        setPixelY(coordY);






    }

    @Override
    public void setPixelX(int x) {
        this.setX(x-69);
        myCoordX = x;
    }

    @Override
    public void setPixelY(int y) {
        this.setY(y-69);
        myCoordY = y;
    }

    @Override
    public int getPixelX() {

        return myCoordX;
    }

    @Override
    public int getPixelY() {
        return myCoordY;
    }
}
