package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnRecipe;
    private Button btnCamera;
    ListView simpleList;
    String itemsList[] = {"Banana", "Apple"};
    int pictures[] = {R.drawable.banana, R.drawable.apple};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleList = (ListView) findViewById(R.id.listViewItems);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), itemsList, pictures);
        simpleList.setAdapter(customAdapter);

        btnRecipe = (Button) findViewById(R.id.buttonRecipe);
        btnRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_3 = new Intent(getApplicationContext(), RecipeActivity.class);
                startActivity(intent_3);

            }
        });
        btnCamera = (Button) findViewById(R.id.buttonCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_3 = new Intent(getApplicationContext(), DetectorActivity.class);
                startActivity(intent_3);

            }
        });
    }
}
