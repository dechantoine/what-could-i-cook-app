package org.tensorflow.lite.examples.detection;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class ItemsContainer extends Application {

    private List<String> itemsList = new ArrayList<String>();
    private List<Integer> pictures = new ArrayList<>();

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
            int resID = getResources().getIdentifier(name, "drawable", getPackageName());
            this.pictures.add(resID);
        }
    }

    public List<Integer> getPictures(){
        return this.pictures;
    }
}