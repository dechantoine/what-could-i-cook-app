/*********************************************************
 5. Recipe activity - objective is to displaying the recipes based on Main activity list items

 *********************************************************/

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

//This is the activity in charge of displaying the recipes

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
        this.itemsList = ((ItemsContainer) this.getApplication()).getItemsList(); //we get the items stored in the ItemsContainer
        getListRecipes(); //see below
        getPicturesList(); //see below
        getStarsList(); //see below
        getTimesList(); //see below
        recipeList = (ListView) findViewById(R.id.list_recipes);
        RecipeAdapter recipeAdapter = new RecipeAdapter(getApplicationContext(), this.recipesList, this.picturesList, this.starsList, this.timesList); //we create and feed the Adapter with the elements it will display
        recipeList.setAdapter(recipeAdapter);

    }


    public void getListRecipes() {
        //this function is built to get all recipes that can be done with our currents items
        //this.recipesList.add("apple pie"); //for testing purposes
        //this.recipesList.add("smoothie apple banana"); //for testing purposes
        //this.recipesList.add("banana pie"); //for testing purposes
        Resources res = getResources();
        TypedArray titles = res.obtainTypedArray(R.array.title); //here we load all recipes titles from recipes.xml
        TypedArray items = res.obtainTypedArray(R.array.items); //here we load all recipes items from recipes.xml
        for (int k = 0; k < this.itemsList.size(); k++) { //for each current item
            String name = this.itemsList.get(k);
            for (int j = 0; j < items.length(); j++) { //for each line in the items Array in recipes.xml
                String[] items_list = items.getString(j).split(" "); //from the String "item1 item2 item3" to the String[] ["item1", "item2", "item3"]
                for (int h = 0; h < items_list.length; h++) { //for each element in the String[] created
                    if (items_list[h].equals(name)) { //we compare the current item with items in the String[]
                        this.recipesList.add(titles.getString(j)); //if there is a match, the associated recipe title in recipes.xml is added to the list of current recipes
                    }
                }
            }
        }
        //this part is to get ride of multiplicity
        Set<String> set = new HashSet<>(this.recipesList);
        this.recipesList.clear();
        this.recipesList.addAll(set);
        items.recycle(); //this is a good use , but I honestly don't know why. App seems to work also without it
        titles.recycle();
    }

    public void getPicturesList(){
        Resources res = getResources();
        for(int k=0; k<this.recipesList.size(); k++){ //now we have the current recipes thanks to getListRecipes()
            String name = this.recipesList.get(k).replaceAll(" ","_"); //from "apple pie" to "apple_pie" (because the first is creating issues)
            int resID = res.getIdentifier(name, "drawable", getPackageName()); //get the identifier of the associated drawable
            this.picturesList.add(resID);
        }
    }

    public void getStarsList(){
        Resources res = getResources();
        TypedArray titles = res.obtainTypedArray(R.array.title); //here we load all recipes titles from recipes.xml
        TypedArray stars = res.obtainTypedArray(R.array.star); //here we load all recipes stars from recipes.xml
        for(int k=0; k<this.recipesList.size(); k++){ //now we have the current recipes thanks to getListRecipes()
            String name = this.recipesList.get(k);
            int i = 1; //this is meant to avoid bug
            for(int j=0; j<titles.length(); j++){ //for each line of the title array
                if(titles.getString(j).equals(name)){ //if the line matched with the current recipe name
                    i = j; //we collect the line of the current recipe
                }
            }
            String star = stars.getString(i); //we collect the stars of the current recipe from recipes.xml
            int resID = getResources().getIdentifier("stars_"+star, "drawable", getPackageName()); //stars are stored as drawable : stars_0.jpg, stars_1.jpg and so and so forth
            this.starsList.add(resID);
        }
        stars.recycle();
        titles.recycle();
    }

    public void getTimesList() {
        //this function works with the same structure as the previous one
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
