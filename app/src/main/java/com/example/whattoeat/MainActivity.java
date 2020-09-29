package com.example.whattoeat;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MainActivity extends AppCompatActivity {
    private ImageButton button;
    private TextView today_weather;
    public static String temperature;
    public static String weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       button = findViewById(R.id.see_option);
       today_weather = findViewById(R.id.today_weather);

        new getweather().execute();  // Executing AsyncTask to run methods in the background and not interfere with the UI

       button.setOnClickListener(new View.OnClickListener() {
           // Click button to move onto the next page
           @Override
           public void onClick(View v) {
               nextActivity();
           }
       });
    }

    public void nextActivity(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public class getweather extends AsyncTask<Void, Void, Void>
    {
        // Parse HTML from the URL to scrape current temperature and weather status in Sunnyvale, California Only, using Jsoup. Jsoup.jar in app.lib
        String summary;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String html = "https://www.wunderground.com/weather/us/ca/sunnyvale/94087";
                Document doc = Jsoup.connect(html).get();
                Elements temp_contents = doc.select("span.test-false.wu-unit.wu-unit-temperature > span.wu-value.wu-value-to");
                Elements weather_contents = doc.select("p");

                int counter = 1;
                for(Element e: weather_contents)
                {
                    Log.i("weather : ", e.text());  // Indicates each <p> text
                    if(counter == 5) {
                        weather = e.text();
                        break;
                    }
                    else
                        counter++;
                }

                temperature = temp_contents.text();


                Log.i("temperature type : ", temperature);

                Log.i("temperature : ", temperature);
                Log.i("weather : ", weather);
                Log.d("Document creation", "Successful");

            }catch(Exception e)
            {
                Log.d("Document creation", "Failed");
                e.printStackTrace();
            }

            summary =  "In Sunnyvale, California "+"\n" + "Current temperature is : " + temperature + " F \n" + "It is \"" + weather + "\" outside.";
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            today_weather.setText(summary);
        }
    }
}
