package com.example.matias.c2m9monitoringwebserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    EditText welcomeMsg;
    TextView infoIP;
    TextView infoMsg;
    String msgLog;

    public ServerSocket httpServerSocket;


    private class HttpServerThread extends Thread {

        static final Integer HttpServerPORT;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
