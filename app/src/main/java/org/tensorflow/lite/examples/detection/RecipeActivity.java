package org.tensorflow.lite.examples.detection;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecipeActivity extends AppCompatActivity {

    List<String> itemsList = new ArrayList<String>();
    List<String> recipesList = new ArrayList<String>();
    List<Integer> picturesList = new ArrayList<>();
    List<Integer> starsList = new ArrayList<>();
    List<String> timesList = new ArrayList<>();
    ListView recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.itemsList = ((ItemsContainer) this.getApplication()).getItemsList();
        getListRecipes();
        getPicturesList();
        getStarsList();
        getTimesList();
        recipeList = (ListView) findViewById(R.id.list_recipes);
        RecipeAdapter recipeAdapter = new RecipeAdapter(getApplicationContext(), this.recipesList, this.picturesList, this.starsList, this.timesList);
        recipeList.setAdapter(recipeAdapter);

    }


    public void getListRecipes() {
        //this.recipesList.add("apple pie");
        //this.recipesList.add("smoothie apple banana");
        Resources res = getResources();
        TypedArray titles = res.obtainTypedArray(R.array.title);
        TypedArray items = res.obtainTypedArray(R.array.items);
        for (int k = 0; k < this.itemsList.size(); k++) {
            String name = this.itemsList.get(k);
            for (int j = 0; j < items.length(); j++) {
                String[] items_list = items.getString(j).split(" ");
                for (int h = 0; h < items_list.length; h++) {
                    if (items_list[h].equals(name)) {
                        this.recipesList.add(titles.getString(j));
                    }
                }
            }
        }
        Set<String> set = new HashSet<>(this.recipesList);
        this.recipesList.clear();
        this.recipesList.addAll(set);
        items.recycle();
        titles.recycle();
    }

    public void getPicturesList(){
        Resources res = getResources();
        for(int k=0; k<this.recipesList.size(); k++){
            String name = this.recipesList.get(k).replaceAll(" ","_");
            int resID = res.getIdentifier(name, "drawable", getPackageName());
            this.picturesList.add(resID);
        }
    }

    public void getStarsList(){
        Resources res = getResources();
        TypedArray titles = res.obtainTypedArray(R.array.title);
        TypedArray stars = res.obtainTypedArray(R.array.star);
        for(int k=0; k<this.recipesList.size(); k++){
            String name = this.recipesList.get(k);
            int i = 1;
            for(int j=0; j<titles.length(); j++){
                if(titles.getString(j).equals(name)){
                    i = j;
                }
            }
            String star = stars.getString(i);
            int resID = getResources().getIdentifier("stars_"+star, "drawable", getPackageName());
            this.starsList.add(resID);
        }
        stars.recycle();
        titles.recycle();
    }

    public void getTimesList() {
        Resources res = getResources();
        TypedArray titles = res.obtainTypedArray(R.array.title);
        TypedArray times = res.obtainTypedArray(R.array.time);
        for (int k = 0; k < this.recipesList.size(); k++) {
            String name = this.recipesList.get(k);
            int i = 1;
            for (int j = 0; j < titles.length(); j++) {
                if (titles.getString(j).equals(name)) {
                    i = j;
                }
            }
            String time = times.getString(i);
            this.timesList.add(time);
        }
        times.recycle();
        titles.recycle();
    }
}
