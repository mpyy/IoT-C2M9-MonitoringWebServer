package com.example.matias.c2m9monitoringwebserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Activity class to allow the application to be run. This class
 * immediately closes after running the service in the background
 */
public class MainActivity extends AppCompatActivity {

    EditText welcomeMsg;
    TextView infoIP;
    TextView infoMsg;
    String msgLog;

    public ServerSocket httpServerSocket;


    private class HttpServerThread extends Thread {

        static final int HttpServerPORT;

        public void run() {
        }
    }

    private class HttpResponseThread extends Thread {

        Socket socket;
        String h1;

        HttpResponseThread(Socket socket, String msg) {
        }

        public void run() {
        }
    }

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
