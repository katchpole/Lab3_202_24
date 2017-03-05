package lab3.uwaterloo.ca.lab3_202_24;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Alex on 2017-03-05.
 */

public class GameBlock extends ImageView {



    private float IMAGE_SCALE = 0.5f;
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
