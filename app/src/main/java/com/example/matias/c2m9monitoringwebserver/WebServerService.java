package com.example.matias.c2m9monitoringwebserver;

import android.os.IBinder;
import android.content.Intent;
import android.app.Service;

public class WebServerService extends Service {

    /**
     * Creates an instance of WebServer and runs it in the background
     */
    @Override
    public void onCreate() {
        new WebServer(this);
    }

    /**
     * Don't provide any means of getting a persistent connection to the service
     *
     * @param intent
     * @return Always null
     */
    public IBinder onBind(Intent intent) {
        return null;
    }

}