package com.example.matias.c2m9monitoringwebserver;

import java.util.ArrayList;

import android.content.Context;

public class SystemInfo {

    private static final int THREAD_SLEEP;

    private static final int PERCENTAGE;

    private Context context;

    public SystemInfo(Context context) {
    }

    ArrayList getGPIOValues() {
        return null;
    }

    ArrayList getGPIODirection() {
        return null;
    }

    boolean getBluetoothStatus() {
        return null;
    }

    boolean getLocationStatus() {
        return null;
    }

    String getWifiNetwork() {
        return null;
    }

    boolean getWifiStatus() {
        return null;
    }

    String[] getUSBList() {
        return null;
    }

    int getNumCores() {
        return null;
    }

    String getMemoryUsage() {
        return null;
    }

    String getCpuUsage() {
        return null;
    }

    long parseCpu(String load) {
        return 0;
    }

    String getLastUpdate() {
        return null;
    }

}