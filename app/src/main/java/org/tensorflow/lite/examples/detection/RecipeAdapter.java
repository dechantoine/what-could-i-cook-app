package org.tensorflow.lite.examples.detection;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

//This is class is designed to add more features to ListView than the original BaseAdapter

public class RecipeAdapter extends BaseAdapter {
    Context context;
    List<Integer> pictures = new ArrayList<>();
    LayoutInflater inflter;
    List<String> recipesList = new ArrayList<String>();
    List<Integer> starsList = new ArrayList<>();
    List<String> timesList = new ArrayList<>();

    public RecipeAdapter(Context applicationContext, List<String> recipesList, List<Integer> pictures, List<Integer> starsList, List<String> timesList) {
        //all values are inherited from RecipeActivity
        this.context = applicationContext;
        this.recipesList = recipesList;
        this.pictures = pictures;
        this.starsList = starsList;
        this.timesList = timesList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return recipesList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listrecipes, null);
        TextView item = (TextView) view.findViewById(R.id.recipeTitle);
        TextView time = (TextView) view.findViewById(R.id.recipe_time);
        ImageView icon = (ImageView) view.findViewById(R.id.recipe_pic);
        ImageView stars = (ImageView) view.findViewById(R.id.recipe_stars);
        item.setText(this.recipesList.get(i));
        icon.setImageResource(pictures.get(i));
        stars.setImageResource(starsList.get(i));
        time.setText(this.timesList.get(i) + " MIN ");
        return view;
    }
}