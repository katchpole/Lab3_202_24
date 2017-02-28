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

                        Log.d(TAG, "run: " + count++);      // (current line for testing only) add in movement direction from lab two, grabs direction and cues animation accordingly
                    }
                }
        );


    }
}
