package com.example.mahaautomobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loader = new ProgressDialog(MainActivity.this);
        loader.setMessage("Loading Please Wait");
        loader.setIndeterminate(false);
        loader.setCancelable(false);
        loader.show();

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    loader.dismiss();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

    }
}
