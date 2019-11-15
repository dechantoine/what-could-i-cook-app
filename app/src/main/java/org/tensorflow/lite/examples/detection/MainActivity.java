package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.tensorflow.lite.examples.detection.tracking.MultiBoxTracker;

public class MainActivity extends AppCompatActivity {

    private Button btnRecipe;
    private Button btnCamera;
    ListView simpleList;
    String label = MultiBoxTracker.getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //String a = "apple";
        //String b = "banana";
        if (label != null) {
            String c = label;
            ((ItemsContainer) this.getApplication()).addItem(c);
        }
        //((ItemsContainer) this.getApplication()).addItem(a);
        //((ItemsContainer) this.getApplication()).addItem(b);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleList = (ListView) findViewById(R.id.listViewItems);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), ((ItemsContainer) this.getApplication()).getItemsList(), ((ItemsContainer) this.getApplication()).getPictures());
        simpleList.setAdapter(customAdapter);

        btnRecipe = (Button) findViewById(R.id.buttonRecipe);
        btnRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent c = new Intent(getApplicationContext(), RecipeActivity.class);
                startActivity(c);

            }
        });
        btnCamera = (Button) findViewById(R.id.buttonCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent d = new Intent(getApplicationContext(), DetectorActivity.class);
                startActivity(d);

            }
        });
    }
}
