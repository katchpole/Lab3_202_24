package lab3.uwaterloo.ca.lab3_202_24;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Timer;

public class MainActivity extends AppCompatActivity implements SensorEventListener, GestureCallback{


    private TextView textViewGestureStatus;
    double[][] accelArray = new double[100][3];     //csv file array


    private SensorManager mSensorManager;

    private Sensor mAccelerometer;


    private AccelerationHandler accelerationHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sensor stuff
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int REL_LAYOUT_SIDE_LENGTH = displayMetrics.widthPixels;

        //reference Relative layout
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.rel_layout);
        layout.getLayoutParams().width = REL_LAYOUT_SIDE_LENGTH;
        layout.getLayoutParams().height = REL_LAYOUT_SIDE_LENGTH;
        layout.setBackgroundResource(R.drawable.gameboard);




        accelerationHandler = new AccelerationHandler(getApplicationContext(), layout, "acceleration", this);

        textViewGestureStatus = new TextView(getApplicationContext());
        textViewGestureStatus.setGravity(Gravity.CENTER_HORIZONTAL);
        textViewGestureStatus.setTextSize(26);
        textViewGestureStatus.setTextColor(Color.WHITE);
        layout.addView(textViewGestureStatus);

//testing for timer class
        Timer timerTest = new Timer();
        GameLoopTask testTask1 = new GameLoopTask(this, layout, getApplicationContext());
        timerTest.schedule(testTask1, 1000, 1000);



    }

    @Override
    public void onGestureDetect(Direction direction){
        if (direction == Direction.RIGHT){
            textViewGestureStatus.setText("RIGHT");
        }else if (direction == Direction.LEFT){
            textViewGestureStatus.setText("LEFT");
        }else if (direction == Direction.UP){
            textViewGestureStatus.setText("UP");
        }else if (direction == Direction.DOWN){
            textViewGestureStatus.setText("DOWN");
        }
    }


    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_GAME);       //should make SENSOR_DELAY_GAME?
    }

    @Override
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){
        //Do nothing...
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        //changes in accelerometer
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            accelerationHandler.HandleOutput(event.values);
            accelArray = accelerationHandler.GetAccelArray();
        }
    }





}
