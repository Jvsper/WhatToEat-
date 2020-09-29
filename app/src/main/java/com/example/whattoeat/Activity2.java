package com.example.whattoeat;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Activity2 extends AppCompatActivity
{
    TextView suggestion_intro;  // Intro of the page

    // ImageViews and TextViews for the appropriate menus
    ImageView imgView1;
    ImageView imgView2;
    ImageView imgView3;
    ImageView imgView4;
    ImageView imgView5;
    TextView food_descriptions1;
    TextView food_descriptions2;
    TextView food_descriptions3;
    TextView food_descriptions4;
    TextView food_descriptions5;
    private final int NUMBER_OF_SUGGESTIONS = 5;
    private String[] menu;  // Menus to display to the TextView
    int temperature = Integer.parseInt(MainActivity.temperature);  // Parsed temperature converted to int
    private String below_thirty; // if temperature is below 30, print this string

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Got rid of default status bar and changed to toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Suggestions");

        setMenu(); // Setting menu
        suggestion_intro = (TextView)findViewById(R.id.suggestion_intro);

        suggestion_intro.setText("Since it's " + MainActivity.weather + " and " + temperature +" F. \n" + "How about these?");

        // Initializing components
        imgView1 = (ImageView)findViewById(R.id.food1);
        imgView2 = (ImageView)findViewById(R.id.food2);
        imgView3 = (ImageView)findViewById(R.id.food3);
        imgView4 = (ImageView)findViewById(R.id.food4);
        imgView5 = (ImageView)findViewById(R.id.food5);

        food_descriptions1 = (TextView)findViewById(R.id.food1_desc);
        food_descriptions2 = (TextView)findViewById(R.id.food2_desc);
        food_descriptions3 = (TextView)findViewById(R.id.food3_desc);
        food_descriptions4 = (TextView)findViewById(R.id.food4_desc);
        food_descriptions5 = (TextView)findViewById(R.id.food5_desc);

        // Display the contents to the components
        display();
    }

    public void display()
    {
        if(!(temperature < 30))
        {
            this.food_descriptions1.setText(menu[0]);
            this.food_descriptions2.setText(menu[1]);
            this.food_descriptions3.setText(menu[2]);
            this.food_descriptions4.setText(menu[3]);
            this.food_descriptions5.setText(menu[4]);

            if (temperature >= 90) {
                this.imgView1.setImageResource(R.drawable.a1);
                this.imgView2.setImageResource(R.drawable.a2);
                this.imgView3.setImageResource(R.drawable.a3);
                this.imgView4.setImageResource(R.drawable.a4);
                this.imgView5.setImageResource(R.drawable.a5);
            } else if (temperature < 90 && temperature >= 80) {
                this.imgView1.setImageResource(R.drawable.a6);
                this.imgView2.setImageResource(R.drawable.a7);
                this.imgView3.setImageResource(R.drawable.a8);
                this.imgView4.setImageResource(R.drawable.a9);
                this.imgView5.setImageResource(R.drawable.a10);
            } else if (temperature < 80 && temperature >= 70) {
                this.imgView1.setImageResource(R.drawable.a11);
                this.imgView2.setImageResource(R.drawable.a12);
                this.imgView3.setImageResource(R.drawable.a13);
                this.imgView4.setImageResource(R.drawable.a14);
                this.imgView5.setImageResource(R.drawable.a15);
            } else if (temperature < 70 && temperature >= 60) {
                this.imgView1.setImageResource(R.drawable.a16);
                this.imgView2.setImageResource(R.drawable.a17);
                this.imgView3.setImageResource(R.drawable.a18);
                this.imgView4.setImageResource(R.drawable.a19);
                this.imgView5.setImageResource(R.drawable.a20);
            } else if (temperature < 60 && temperature >= 50) {
                this.imgView1.setImageResource(R.drawable.a21);
                this.imgView2.setImageResource(R.drawable.a22);
                this.imgView3.setImageResource(R.drawable.a23);
                this.imgView4.setImageResource(R.drawable.a24);
                this.imgView5.setImageResource(R.drawable.a25);
            } else if (temperature < 50 && temperature >= 30) {
                this.imgView1.setImageResource(R.drawable.a26);
                this.imgView2.setImageResource(R.drawable.a27);
                this.imgView3.setImageResource(R.drawable.a28);
                this.imgView4.setImageResource(R.drawable.a29);
                this.imgView5.setImageResource(R.drawable.a30);
            }
        }
        else {
            food_descriptions1.setText(below_thirty);
        }

    }

    private void setMenu()
    {
        String[] ninty = {
                "1. Fresh Basil Salad with Prosciutto-Wrapped Melon & Seed-Rolled Goat Cheese",
                "2. Crab California Roll Burrito",
                "3. Mango Peanut Tempeh Tacos",
                "4. Two-Pea Pesto Chicken Salad",
                "5. Italian Corner Deli Sandwich"};

        String[] eighty = {
                "1. Chilled Avocado Soup Topped with Crab",
                "2. Cold Cucumber Soup with Yogurt and Dill",
                "3. Mediterranean Chickpea Salad",
                "4. Gazpacho",
                "5. Baked Catfish"};

        String[] seventy = {
                "1. Beer Battered Fish",
                "2. Shrimp Enchiladas",
                "3. Jerk Chicken",
                "4. Chicken Tacos",
                "5. Asian BBQ Grilled Salmon"};

        String[] sixty = {
                "1. Honey Balsamic Grilled Chicken Thighs",
                "2. Mussels with Tomatoes and Garlic",
                "3. Perfect Baked Cod",
                "4. Classic Falafel",
                "5. Bruschetta Chicken Stuffed Avocados"};

        String[] fifty = {
                "1. Honey Soy Grilled Pork Chops",
                "2. Eggplant Parm",
                "3. MShrimp Ceviche",
                "4. Zucchini Lasagna Roll-Ups",
                "5. Cilantro Lime Grilled Salmon"};

        String[] thirty = {
                "1. Cassoulet with Sausage",
                "2. Bread Pudding Cups with Bourbon Sauce",
                "3. Hot Bowl of Pho",
                "4. Chorizo and Polenta Lasagna",
                "5. Japanese Ramen"};

        menu = new String[NUMBER_OF_SUGGESTIONS];

        if (temperature >= 90) {
            for (int i = 0; i < NUMBER_OF_SUGGESTIONS; i++) {
                this.menu[i] = ninty[i];
            }
        } else if (temperature < 90 && temperature >= 80) {
            for (int i = 0; i < NUMBER_OF_SUGGESTIONS; i++) {
                this.menu[i] = eighty[i];
            }
        } else if (temperature < 80 && temperature >= 70) {
            for (int i = 0; i < NUMBER_OF_SUGGESTIONS; i++) {
                this.menu[i] = seventy[i];
            }
        } else if (temperature < 70 && temperature >= 60) {
            for (int i = 0; i < NUMBER_OF_SUGGESTIONS; i++) {
                this.menu[i] = sixty[i];
            }
        } else if (temperature < 60 && temperature >= 50) {
            for (int i = 0; i < NUMBER_OF_SUGGESTIONS; i++) {
                this.menu[i] = fifty[i];
            }
        } else if (temperature < 50 && temperature >= 30) {
            for (int i = 0; i < NUMBER_OF_SUGGESTIONS; i++) {
                this.menu[i] = thirty[i];
            }
        } else
            below_thirty = "Below 30?!? \nYou can't be in Sunnyvale, California... It's SUNNYvale...";
    }
}
