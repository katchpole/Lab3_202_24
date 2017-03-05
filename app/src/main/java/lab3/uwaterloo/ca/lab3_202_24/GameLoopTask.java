package lab3.uwaterloo.ca.lab3_202_24;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.TimerTask;

import static android.content.ContentValues.TAG;

/**
 * Created by Alex on 2017-02-21.
 */

public class GameLoopTask extends TimerTask {
    public static int count  = 0;
    Activity myActivity;
    Context myContext;
    RelativeLayout myRL;
    int blockLayoutIncrement = 243;     // coordinate pixel constant for moving one block up or down
    private enum gameDirections{UP, DOWN, LEFT, RIGHT, NO_MOVEMENT};
    private gameDirections currentState = gameDirections.DOWN.NO_MOVEMENT;


    public GameLoopTask(Activity myActivity1, RelativeLayout myRL1, Context myContext1 ){
        myActivity = myActivity1;
        myContext = myContext1;
        myRL = myRL1;

        createBlock();


    }
    @Override
    public void run() {
        this.myActivity.runOnUiThread(
                new Runnable(){
                    public void run(){

                       // Log.d(TAG, "run: " + count++);      // for testing only
                    }
                }
        );


    }

    private void createBlock(){
        GameBlock newBlock = new GameBlock(myContext,0, 0);//top left is (0,0), image scaling offset in GameBlock
        myRL.addView(newBlock);
    }

    private void setDirection(gameDirections direction){
        currentState = direction;
        Log.d(TAG, "setDirection: " + direction);

    }
}
