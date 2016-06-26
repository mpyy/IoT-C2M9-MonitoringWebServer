package com.example.matias.c2m9monitoringwebserver;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Class representing the HTTP response thread.
 *
 * Created by matias on 20.6.2016.
 */
public class HttpResponseThread extends Thread {
    Socket socket;
    String msg;
    String msgLog;
    private static final String TAG = "HttpResponseThread";

    /**
     * Constructor for the HTTP response thread
     *
     * @param socket    Socket object for the connection
     * @param msg       The contents of the HTTP request
     */
    HttpResponseThread(Socket socket, String msg){
        this.socket = socket;
        this.msg = msg;
        msgLog = "";
    }

    @Override
    public void run() {

        PrintWriter os;

        try {

            os = new PrintWriter(socket.getOutputStream(), true);

            Log.e(TAG, "Msg: " + msg);

            os.print(msg + "\r\n");
            os.flush();

            InetAddress clientInetAddressBeforeClose = socket.getInetAddress();
            socket.close();
            InetAddress clientInetAddressAfterClose = socket.getInetAddress();

            if (clientInetAddressBeforeClose == null) {
                Log.e(TAG, "clientInetAddressBeforeClose == null");
            } else {
                Log.e(TAG, "clientInetAddressBeforeClose = " + clientInetAddressBeforeClose.toString());
            }

            if (clientInetAddressAfterClose == null) {
                Log.e(TAG, "clientInetAddressAfterClose == null");
            } else {
                Log.e(TAG, "clientInetAddressAfterClose = " + clientInetAddressAfterClose.toString());
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
