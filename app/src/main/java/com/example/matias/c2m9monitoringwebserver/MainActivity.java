package com.example.matias.c2m9monitoringwebserver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Activity class to allow the application to be run. This class
 * immediately closes after running the service in the background
 */
public class MainActivity extends Activity {

    /**
     * Instantiates WebServerService to run in the background
     *
     * @param savedInstanceState Reference to bundle object. Activities can be
     *                           restored to a former state using data saved
     *                           in this bundle. This parameter is unused.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, WebServerService.class);
        startService(intent);
        finish();
    }
}
