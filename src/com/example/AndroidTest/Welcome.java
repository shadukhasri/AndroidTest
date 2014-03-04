package com.example.AndroidTest;

/**
 * Created by Tmi on 2/27/14.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Welcome extends Activity {
    private EditText usernameField;
    private User user;
    private Button startButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_welcome);
        startButton = (Button) findViewById(R.id.Start);
        usernameField = (EditText) findViewById(R.id.Username);

        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent welGame = new Intent(Welcome.this, MyActivity.class);
                welGame.putExtra(MyActivity.APPUSER, new User(usernameField.getText() + ""));
                startActivity(welGame);

                finish();
            }
        });
    }
}
