package com.example.AndroidTest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGame extends Activity {
    public static final String USER = "user";
    private TextView finalScoreTextView;
    private Button yesButton, noButton;
    private User user;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.end_game);
        user = (User) getIntent().getSerializableExtra(USER);
        finalScoreTextView = (TextView) findViewById(R.id.ScoreTw);

        yesButton = (Button) findViewById(R.id.YesButton);
        noButton = (Button) findViewById(R.id.NoButton);
        finalScoreTextView.setText("" + user.getUsername() + " " + user.getScore());
        yesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(EndGame.this, MyActivity.class);
                intent.putExtra(MyActivity.APPUSER, user);
                startActivity(intent);
                finish();

            }
        });
        noButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
    }
}

