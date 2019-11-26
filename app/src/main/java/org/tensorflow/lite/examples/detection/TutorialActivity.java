package org.tensorflow.lite.examples.detection;

/*********************************************************
 2. Tutorial activity - objective is to explains how to use application
 Features:
 - Image slider used from: https://github.com/smarteist/Android-Image-Slider
 - button
 - setting intent for the third activity - Main activity (home)

 *********************************************************/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import autoimageslider.IndicatorAnimations;
import autoimageslider.IndicatorView.draw.controller.DrawController;
import autoimageslider.SliderAnimations;
import autoimageslider.SliderView;

public class TutorialActivity extends AppCompatActivity {

    private Button btnNext;
    private SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        // IMPLEMENTATION OF SLIDER
        sliderView = findViewById(R.id.imageSlider);
        final SliderAdapterExample adapter = new SliderAdapterExample(this);
        adapter.setCount(4);
        sliderView.setSliderAdapter(adapter);
        //set indicator animation by using SliderLayout
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
            }
        });

        // Setting up button to display Main activity using intent
        btnNext = (Button) findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent b = new Intent(TutorialActivity.this, MainActivity.class);
                startActivity(b);
            }
        });
    }
}
