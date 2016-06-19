package com.example.matias.c2m9monitoringwebserver;

import android.content.Context;

import org.json.JSONObject;

/**
 * Class detailing the methods needed to perform HTTP requests and send HTTP messages
 */
public class WebServer {

    private static final int REFRESH_RATE = 5000;
    private static final String TAG = "WebServer";
    private JSON json;
    private JSONObject jsonObject;
    private Context context;

    public WebServer(Context context) {
    }

    public void updateJSONData() {
    }

    public String processMessage(String message) {
        return null;
    }

    public void beginServer(String ipAddress, String port) {
    }

    public String getIPAddress() {
        return null;
    }

    public String setUpHTTPMessage(String content, String content_type) {
        return null;
    }

}