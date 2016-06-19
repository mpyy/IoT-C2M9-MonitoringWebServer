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

    /**
     * Instantiates the instance variables that will be used
     * to create and refresh the JSON. Constructor for the class.
     *
     * @param context   Context passed from the Service to enable JSON to gather
     *                  SystemInfo and to enable getString()
     */
    public WebServer(Context context) {
    }

    /**
     * Performs a call to createJSON to generate a JSON string to display in the HTTP Response
     */
    public void updateJSONData() {
    }

    /**
     * Parses the messages received from the WebServer and returns the appropriate string
     *
     * @param message   String containing the HTTP request
     * @return  String containing the content of the HTTP response
     */
    public String processMessage(String message) {
        return null;
    }

    /**
     * Begin the server, to be implemented in Java instead of C
     *
     * @param ipAddress String containing the ipAddress of the device
     * @param port  String containing the port
     */
    public void beginServer(String ipAddress, String port) {
    }

    /**
     * Iterates through the device's IPAddresses and returns first non-local IP address
     *
     * @return  String containing the first non-local IP address of the device.
     */
    public String getIPAddress() {
        return null;
    }

    /**
     * Formats the message into an HTTP request that is to be sent to the server.
     *
     * @param content   String containing the content of the message
     * @param content_type  String containing the "Content-Type"
     * @return  String containing the formatted HTTP request message
     */
    public String setUpHTTPMessage(String content, String content_type) {
        return null;
    }

}