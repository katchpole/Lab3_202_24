package lab3.uwaterloo.ca.lab3_202_24;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by Alex on 2017-03-05.
 */

public class GameBlock extends ImageView {



    private final float IMAGE_SCALE = 1.0f;
    private static int myCoordX = 0;
    private static int myCoordY = 0;


    public GameBlock(Context myContext, int coordX, int coordY) {
        super(myContext);
        this.setImageResource(R.drawable.gameblock);
        this.setScaleX(IMAGE_SCALE);
        this.setScaleY(IMAGE_SCALE);

        myCoordX = coordX;
        myCoordY = coordY;

        this.setX(myCoordX);
        this.setY(myCoordY);






    }

}
