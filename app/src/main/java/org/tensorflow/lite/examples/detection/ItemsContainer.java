package org.tensorflow.lite.examples.detection;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

//This class is designed to deal with the food items and make them available for the whole app

public class ItemsContainer extends Application {

    private List<String> itemsList = new ArrayList<String>(); //this array will contain String name of the food items
    private List<Integer> pictures = new ArrayList<>(); //this array will contain ID of the drawable associated with each item

    public List<String> getItemsList() {
        return itemsList;
    }

    public void addItem(String item) {
        this.itemsList.add(item);
        this.updatePictures();
    }

    public void removeItem(int i) {
        this.itemsList.remove(i);
        this.updatePictures();
    }

    public void updatePictures(){
        this.pictures.clear();
        for(int k=0; k<this.itemsList.size(); k++){
            String name = this.itemsList.get(k);
            int resID = getResources().getIdentifier(name, "drawable", getPackageName()); //all pictures have been given the same name than the associated food item
            this.pictures.add(resID);
        }
    }

    public List<Integer> getPictures(){
        return this.pictures;
    }
}