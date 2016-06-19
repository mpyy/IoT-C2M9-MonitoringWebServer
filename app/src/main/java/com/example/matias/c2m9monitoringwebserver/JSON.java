package com.example.matias.c2m9monitoringwebserver;

import android.content.Context;

import org.json.JSONObject;

/**
 * JSON creates a JSONObject that includes SystemInformation
 * about the device. (See SystemInfo for the parsed information).
 */
public class JSON {

    private SystemInfo info;

    private Context context;

    /**
     * Constructor for the class.
     * @param context   WebServerService class passed into the private instance
     *                  SystemInfo to enable it to pull information regarding
     *                  the Android device. Additionally, it is used to grab
     *                  strings from strings.xml
     */
    public JSON(Context context) {
    }

    /**
     * Creates a JSONObject that includes information regarding
     * the current device. This method uses the SystemInfo class
     * to gather data.
     * @return  String containing the JSONObject with the SystemInfo information
     */
    public JSONObject createJSON() {
        return null;
    }

}