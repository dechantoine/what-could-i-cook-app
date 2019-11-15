package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnRecipe;
    private Button btnCamera;
    ListView simpleList;
    List<String> itemsList = new ArrayList<String>();
    List<Integer> picture = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String a = "apple";
        String b = "banana";
        itemsList.add(b);
        itemsList.add(a);
        for(int k=0; k<itemsList.size(); k++){
            String name = itemsList.get(k);
            int resID = getResources().getIdentifier(name, "drawable", getPackageName());
            picture.add(resID);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleList = (ListView) findViewById(R.id.listViewItems);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), itemsList, picture);
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
