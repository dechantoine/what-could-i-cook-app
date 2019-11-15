package org.tensorflow.lite.examples.detection;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends BaseAdapter {
    Context context;
    List<Integer> pictures = new ArrayList<>();
    LayoutInflater inflter;
    List<String> itemsList = new ArrayList<String>();

    public CustomAdapter(Context applicationContext, List<String> itemList, List<Integer> pictures) {
        this.context = applicationContext;
        this.itemsList = itemList;
        this.pictures = pictures;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return itemsList.size();
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
        view = inflter.inflate(R.layout.activity_listview, null);
        TextView item = (TextView) view.findViewById(R.id.itemView);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        Button delete = (Button) view.findViewById((R.id.button_discard));
        item.setText(itemsList.get(i));
        icon.setImageResource(pictures.get(i));
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                itemsList.remove(i);
                pictures.remove(i);
                notifyDataSetChanged();
            }
        });
        return view;
    }

}
