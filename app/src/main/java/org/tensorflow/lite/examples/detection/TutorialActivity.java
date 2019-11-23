package org.tensorflow.lite.examples.detection;

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

        sliderView = findViewById(R.id.imageSlider);

        final SliderAdapterExample adapter = new SliderAdapterExample(this);
        adapter.setCount(4);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
            }
        });

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
