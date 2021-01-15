package mik.maev.webviewpractic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SettingsActivity extends AppCompatActivity {
    private LinearLayout google_home;
    private LinearLayout yandex_home;
    private LinearLayout duckduckgo_home;
    private ImageView selected_google;
    private ImageView selected_yandex;
    private ImageView selected_duck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().hide();

        google_home = findViewById(R.id.google_home);
        yandex_home = findViewById(R.id.yandex_home);
        duckduckgo_home = findViewById(R.id.duckduckgo_home);
        selected_google = findViewById(R.id.image_selected_google);
        selected_yandex = findViewById(R.id.image_selected_yandex);
        selected_duck = findViewById(R.id.image_selected_duck);

        SharedPreferences prefs = getSharedPreferences ("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();

        //google.com - 1
        //yandex.ru - 2
        //duckduckgo.com - 3

        int home = prefs.getInt("home_page", 1);
        switch (home){
            case 1:
                selected_google.setVisibility(View.VISIBLE);
                break;

            case 2:
                selected_yandex.setVisibility(View.VISIBLE);
                break;

            case 3:
                selected_duck.setVisibility(View.VISIBLE);
                break;
        }

        google_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (prefs.getInt("home_page", 1)){
                    case 1:
                        selected_google.setVisibility(View.INVISIBLE);
                        break;

                    case 2:
                        selected_yandex.setVisibility(View.INVISIBLE);
                        break;

                    case 3:
                        selected_duck.setVisibility(View.INVISIBLE);
                        break;
                }
                selected_google.setVisibility(View.VISIBLE);
                edit.putInt("home_page", 1);
                edit.apply();
            }
        });

        yandex_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (prefs.getInt("home_page", 1)){
                    case 1:
                        selected_google.setVisibility(View.INVISIBLE);
                        break;

                    case 2:
                        selected_yandex.setVisibility(View.INVISIBLE);
                        break;

                    case 3:
                        selected_duck.setVisibility(View.INVISIBLE);
                        break;
                }
                selected_yandex.setVisibility(View.VISIBLE);
                edit.putInt("home_page", 2);
                edit.apply();
            }
        });

        duckduckgo_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (prefs.getInt("home_page", 1)){
                    case 1:
                        selected_google.setVisibility(View.INVISIBLE);
                        break;

                    case 2:
                        selected_yandex.setVisibility(View.INVISIBLE);
                        break;

                    case 3:
                        selected_duck.setVisibility(View.INVISIBLE);
                        break;
                }
                selected_duck.setVisibility(View.VISIBLE);
                edit.putInt("home_page", 3);
                edit.apply();
            }
        });
    }
}