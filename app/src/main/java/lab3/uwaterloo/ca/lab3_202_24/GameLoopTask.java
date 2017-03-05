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

    public GameLoopTask(Activity myActivity1, RelativeLayout myRL1, Context myContext1){
        myActivity = myActivity1;
        myContext = myContext1;
        myRL = myRL1;
    }
    @Override
    public void run() {
        this.myActivity.runOnUiThread(
                new Runnable(){
                    public void run(){

                        Log.d(TAG, "run: " + count++);      // for testing only
                    }
                }
        );


    }

    private createBlock(){
        GameBlock newBlock = new GameBlock(myRL, 10, 10); //Or any (x,y) of your choice
        myRL.addView(newBlock);
    }
}
