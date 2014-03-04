package com.example.AndroidTest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


import java.util.Random;

public class MyActivity extends Activity {

    private static int counter;
    boolean isFinish;
    private final static String MESSAGE="MY app";
    private boolean isFirst;
    private TextView scoreTextView;
    private Button countButton;
    public TextView timeLeftTextView;
    MyTimer timer;
    private int time;
    public Handler timerHandler;
    private LinearLayout myLayout;

    private int screenWidth, screenHeight;

    public static final String APPUSER = "user";
    User user;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        time = 30;
        counter = 0;
        timer = new MyTimer(this, time);
        isFirst = true;
        myLayout=(LinearLayout)findViewById(R.id.LinearLayout);
        isFinish = false;
        timerHandler = new Handler();

        this.user = (User)getIntent().getSerializableExtra(APPUSER);
        this.user.setScore(counter);
        Toast.makeText(this, this.user.getUsername(), Toast.LENGTH_SHORT).show();


        scoreTextView = (TextView) findViewById(R.id.textView);
        timeLeftTextView = (TextView) findViewById(R.id.RemainingTime);
        timeLeftTextView.setText("30");
        countButton = (Button) findViewById(R.id.button);

        countButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (isFirst) {
                    timer.start();
                    isFirst = false;
                }
                updatePosAndText();
            }
        });
    }

    public void updatePosAndText() {

        screenHeight = myLayout.getHeight();
        screenWidth = myLayout.getWidth();
        System.out.println("Width: " + screenWidth);
        System.out.println("Height: " + screenHeight);

        scoreTextView.setText("" + counter++);

        int x = (new Random()).nextInt(myLayout.getWidth());
        while (x+ countButton.getWidth() > screenWidth) {
            x = (new Random()).nextInt(myLayout.getWidth());
            System.out.println("WHILEX");
        }

        int y = (new Random()).nextInt(myLayout.getHeight());
        while(y + countButton.getHeight() > screenHeight) {
            y = (new Random()).nextInt(myLayout.getHeight());
            System.out.println("WHILEY");
        }

        countButton.setX(x);
        countButton.setY(y);

        System.out.println("SAFE X: " + x);
        System.out.println("SAFE Y: " + y);
    }

    public void setCurrentTime(int cTime) {
        timeLeftTextView.setText("" + cTime);
    }

    public void showFinalScore() {
//        Toast.makeText(this,"Score :"+counter, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MyActivity.this, EndGame.class);
        this.user.setScore(counter);
        intent.putExtra(EndGame.USER, this.user);
        startActivity(intent);
        finish();
    }

    public void timeOff() {
        isFinish = true;
    }
}
