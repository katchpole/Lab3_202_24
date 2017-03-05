package lab3.uwaterloo.ca.lab3_202_24;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.TimerTask;
import java.util.Vector;

import static android.content.ContentValues.TAG;

/**
 * Created by Alex on 2017-02-21.
 */

public class GameLoopTask extends TimerTask implements GestureCallback {

    Activity myActivity;
    Context myContext;
    RelativeLayout myRL;
    int blockLayoutIncrement = 243;     // coordinate pixel constant for moving one block up or down
    Direction CurrentDirection;
    Vector<Animator> animators = new Vector<>();
    GestureCallback mainCallBack;       //


    public GameLoopTask(Activity myActivity1, RelativeLayout myRL1, Context myContext1, GestureCallback mainCallBack ){       //Constructor for gameloopTask
        myActivity = myActivity1;
        myContext = myContext1;
        myRL = myRL1;
        this.mainCallBack = mainCallBack;
        createBlock();


    }
    @Override
    public void onGestureDetect(Direction direction) {      //Stores current direction returned from FSM in Acceleration handler to Current Direction local variable
        mainCallBack.onGestureDetect(direction);        //send direction back to main to be outputed onto screen in textview
        CurrentDirection = direction;
        Log.d(TAG, "setDirection: " + CurrentDirection);

        //state machine to determine target coordinates for appropriate gestures







    }






    @Override
    public void run() {
        this.myActivity.runOnUiThread(
                new Runnable(){
                    public void run(){

                       for (int i = 0; i < animators.size(); i++) {
                           animators.get(i).tick();
                       }
                    }
                }
        );


    }

    private void createBlock(){
        GameBlock newBlock = new GameBlock(myContext,0, 0);//Instantiates new block at top left = (0,0), image scaling offset in GameBlock.
        myRL.addView(newBlock);     //add new block to relative layout


        Animator animator1 = new Animator(newBlock);
        animator1.setTarget(0,blockLayoutIncrement*3);
        animators.add(animator1);
    }


}
