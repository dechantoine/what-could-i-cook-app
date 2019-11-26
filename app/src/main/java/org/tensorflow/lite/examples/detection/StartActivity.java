/*********************************************************
 1. Start activity - innitial screen with the introductory display
 Features:
 - title
 - button
 - setting intent for the second activity - Tutorial activity

 *********************************************************/
package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnContinue = (Button) findViewById(R.id.buttonContinue);

        // Setting up button to display tutorial activity using intent
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a = new Intent(StartActivity.this, TutorialActivity.class);
                startActivity(a);
                finish();

            }
        });
    }

}
