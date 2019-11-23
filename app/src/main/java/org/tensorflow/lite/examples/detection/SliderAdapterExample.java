package org.tensorflow.lite.examples.detection;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import autoimageslider.SliderViewAdapter;

public class SliderAdapterExample extends
        SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;
    private int mCount;

    public SliderAdapterExample(Context context) {
        this.context = context;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
        switch (position) {
            case 0:
                viewHolder.textViewDescription.setText("Choose your product");
                viewHolder.textViewDescription.setTextSize(20);
                viewHolder.textViewDescription.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                viewHolder.imageViewBackground.setImageResource(R.drawable.second);
                break;
            case 1:
                viewHolder.textViewDescription.setText("Scan your product using app");
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                viewHolder.imageViewBackground.setImageResource(R.drawable.third);
                break;
            case 2:
                viewHolder.textViewDescription.setText("Choose recipes from the list");
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                viewHolder.imageViewBackground.setImageResource(R.drawable.fourth);
                break;
            case 3:
                viewHolder.textViewDescription.setText("Use it while shopping");
                viewHolder.textViewDescription.setTextSize(16);
                viewHolder.textViewDescription.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                viewHolder.imageViewBackground.setImageResource(R.drawable.first);
                break;
            default:
                viewHolder.textViewDescription.setTextSize(29);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.VISIBLE);
                viewHolder.imageViewBackground.setImageResource(R.drawable.first);
                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mCount;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }


}
