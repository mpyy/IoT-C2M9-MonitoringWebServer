package com.example.matias.c2m9monitoringwebserver;

import java.util.ArrayList;

import android.content.Context;

/**
 * This class pulls system information (e.g. Bluetooth, WiFi, GPIO, etc.) from the device.
 */
public class SystemInfo {

    private static final int THREAD_SLEEP;

    private static final int PERCENTAGE;

    private Context context;

    /**
     * Constructor for class
     *
     * @param context   WebServerService object to allow SystemInfo to pull
     *                  System Information (e.g. WiFi, Bluetooth,
     *                  LocationServices, etc.) from the android device.
     */
    public SystemInfo(Context context) {
    }

    /**
     * Creates a GpioProcessor to gather the Values of all of the GPIO pins
     *
     * @return  ArrayList<Integer> of values for each GPIO pin
     */
    ArrayList<Integer> getGPIOValues() {
        return null;
    }

    /**
     * Creates a GpioProcessor to gather the Direction of all the pins
     * @return  ArrayList<String> of the Direction of each GPIO pin
     */
    ArrayList<String> getGPIODirection() {
        return null;
    }

    /**
     * Creates a BluetoothAdapter to determine if the Bluetooth on the device is on
     * @return  Boolean signaling whether or not the device's Bluetooth is on
     */
    boolean getBluetoothStatus() {
        return null;
    }

    /**
     * Creates a LocationManager and returns the status of the location provider
     * @return  boolean signaling whether or not the device's Location services are on
     */
    boolean getLocationStatus() {
        return null;
    }

    /**
     * Returns the SSID of the Wifi if it is enabled and available
     * @return  String with the SSID if available
     */
    String getWifiNetwork() {
        return null;
    }

    /**
     * Returns the wifi status of the device
     * @return  Boolean indicating whether or not the Wifi is turned on
     */
    boolean getWifiStatus() {
        return null;
    }

    /**
     * Determines the names of the USB devices currently attached
     * @return  String array of the names of the USB Devices attached
     */
    String[] getUSBList() {
        return null;
    }

    /**
     * Uses the Runtime Environment to get the number of working processors.
     * @return  Number of cores the device's processor has as an integer.
     */
    int getNumCores() {
        return null;
    }

    /**
     * Calculates the percentage of available RAM/memory usage on the device
     * @return  Double representing percentage of memory usage
     */
    String getMemoryUsage() {
        return null;
    }

    /**
     * Calculates the CPU usage of the current device
     * @return  Percentage of CPU usage of the device as a double
     */
    String getCpuUsage() {
        return null;
    }

    /**
     * Separates the idle and used CPU into an array.
     * @param load  is a String read from /proc/stat that contains the
     *              information regarding the CPU usage of the device
     * @return  A long array housing the idle CPU (at index 0) and the used CPU (at index 1)
     */
    long parseCpu(String load) {
        return 0;
    }

    /**
     * Determines the most current update/call to SystemInfo.
     * @return  String with a date and time formatted as "mm/dd/yyyy hh:mm:ss a"
     */
    String getLastUpdate() {
        return null;
    }

}