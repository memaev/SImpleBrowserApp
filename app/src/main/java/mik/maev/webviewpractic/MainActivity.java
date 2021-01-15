package mik.maev.webviewpractic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private ImageButton find_btn;
    private EditText edit_link;
    private ImageButton home_btn;
    private ImageButton settings_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        SharedPreferences prefs = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        find_btn = findViewById(R.id.find_btn);
        edit_link = findViewById(R.id.edit_link);
        home_btn = findViewById(R.id.home_btn);
        settings_btn = findViewById(R.id.settings_btn);
        webView = findViewById(R.id.webView);
        switch (prefs.getInt("home_page", 1)){
            case 1:
                webView.loadUrl("https://google.com");
                edit_link.setText("google.com");
                break;

            case 2:
                webView.loadUrl("https://yandex.ru");
                edit_link.setText("yandex.ru");
                break;

            case 3:
                webView.loadUrl("https://duckduckgo.com");
                edit_link.setText("duckduckgo.com");
                break;
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (prefs.getInt("home_page", 1)){
                    case 1:
                        webView.loadUrl("https://google.com");
                        edit_link.setText("google.com");
                        break;

                    case 2:
                        webView.loadUrl("https://yandex.ru");
                        edit_link.setText("yandex.ru");
                        break;

                    case 3:
                        webView.loadUrl("https://duckduckgo.com");
                        edit_link.setText("duckduckgo.com");
                        break;
                }

            }
        });

        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        find_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = edit_link.getText().toString();
                if (link.length() != 0){
                    String link_ = "https://";
                    webView.loadUrl(link_ + link);
                }
                else Toast.makeText(MainActivity.this, "Enter link, please", Toast.LENGTH_LONG).show();
            }
        });

    }

    public class WebViewClient extends android.webkit.WebViewClient {

        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        // Для старых устройств
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }
}