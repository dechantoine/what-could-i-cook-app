/*********************************************************
 3. Main activity - main interface
 Features:
 - Tensorflow object recognition engine used from:
 https://github.com/tensorflow/examples/tree/master/lite/examples/bert_qa/android
 - Product list
 - Weight converter

 *********************************************************/

package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.tensorflow.lite.examples.detection.tracking.MultiBoxTracker;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Button btnRecipe;
    private Button btnCamera;

    private EditText enterAmount;
    private Button ozButton;
    private Button gButton;

    // create a decimal format object to round our values to 1 decimal places
    DecimalFormat round = new DecimalFormat("0.0");
    //Weight variable
    private static final double
            GRAMS_PER_OUNCE = 28.349523125;

    ListView simpleList;
    String label = MultiBoxTracker.getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Hides keyboard otherwise it pops out automaticly when actvity starts
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        //List function
        //String a = "apple"; //for testing purposes
        //String b = "banana"; //for testing purposes
        //((ItemsContainer) this.getApplication()).addItem(a); //for testing purposes
        //((ItemsContainer) this.getApplication()).addItem(b); //for testing purposes
        if (label != null) {
            String c = label;
            ((ItemsContainer) this.getApplication()).addItem(c); //here we feed the items container with the captured item
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleList = (ListView) findViewById(R.id.listViewItems); //this is the list of items
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), ((ItemsContainer) this.getApplication()).getItemsList(), ((ItemsContainer) this.getApplication()).getPictures()); //here we create and feed the list of items
        simpleList.setAdapter(customAdapter);

        //Weight converter
        enterAmount = (EditText) findViewById(R.id.editText);
        ozButton = (Button) findViewById(R.id.ozButton);
        gButton = (Button) findViewById(R.id.gButton);

        //Set up buttons (event listeners)
        // Button ounces
        ozButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextVal = enterAmount.getText().toString();
                if (editTextVal.isEmpty()) {
                    // display a short message to the screen if things go wrong
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                } else {
                    // we are good
                    double intEditText = Double.parseDouble(extractNumber(editTextVal));
                    // put the returned value into a variable so we can use it
                    double convertedVal = gramsToOunces(intEditText);
                    //use the String.valueOf() method to convert our double value
                    // into it's corresponding string format so we can out put it
                    String stringResult = String.valueOf(round.format(convertedVal));
                    enterAmount.setText(stringResult + " oz ");
                }
            }
        });
        // Button grams
        gButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextVal = enterAmount.getText().toString();
                if (editTextVal.isEmpty()) {
                    // display a short message to the screen if things go wrong
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                } else {
                    // we are good
                    double intEditText = Double.parseDouble(extractNumber(editTextVal));
                    // put the returned value into a variable so we can use it
                    double convertedVal = ouncesToGrams(intEditText);
                    //use the String.valueOf() method to convert our double value
                    // into it's corresponding string format so we can out put it
                    String stringResult = String.valueOf(round.format(convertedVal));
                    enterAmount.setText(stringResult + " g ");
                }
            }
        });
        //Button for calling Recipes activity based on list items. Uses Intent
        btnRecipe = (Button) findViewById(R.id.buttonRecipe);
        btnRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent c = new Intent(getApplicationContext(), RecipeActivity.class);
                startActivity(c);

            }
        });
        //Button for calling camera activity by using Intent
        btnCamera = (Button) findViewById(R.id.buttonCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent d = new Intent(getApplicationContext(), DetectorActivity.class);
                startActivity(d);

            }
        });
    }

    public static double gramsToOunces(double grams) {
        return grams / GRAMS_PER_OUNCE;
    }

    public static double ouncesToGrams(double ounces) {
        return ounces * GRAMS_PER_OUNCE;
    }

    // This part is for Weight converter
    // If user enter number + letter, extract only numbers using regular expression
    public static String extractNumber(String input){

        //replace all characters except digits, +-.
        String regex = "[^-+0-9.]";
        input = input.replaceAll(regex, "");
        System.out.println("After remove non-digit characters: " + input);
        /*
          number format:
          [-]? : if there is 0 or 1 minus sign
          [0-9]+ : one or more digits
          [.]{1}[0-9]+ : . followed by one or more digits
        */
        regex = "[-]?[0-9]+([.]{1}[0-9]+)?";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(input);
        if(matcher.find())
            return (matcher.group(0));
        else
            return "error, no numbers exists!";

    }
}
