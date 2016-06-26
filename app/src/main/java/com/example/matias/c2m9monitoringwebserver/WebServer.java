package com.example.matias.c2m9monitoringwebserver;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

// Added from MainActivity:
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Class detailing the methods needed to perform HTTP requests and send HTTP messages
 */
public class WebServer {

    private static final int REFRESH_RATE = 5000;
    private static final String TAG = "WebServer";
    private static final int SERVER_PORT = 8888;

    private ServerSocket httpServerSocket;
    private JSON json;
    private JSONObject jsonObject;
    private Context context;

    /**
     * Constructor to instantiate the instance variables that will be used
     * to create and refresh the JSON. Runs a thread to update JSON data.
     *
     * @param context Context passed from the Service to enable JSON to gather
     *                SystemInfo and to enable getString()
     */
    public WebServer(Context context) {
        this.context = context;
        json = new JSON(context);
        jsonObject = json.createJSON();

        // Running Thread to continuously update the JSON Data
        new Thread() {
            public void run() {
                while (true) {
                    if (System.currentTimeMillis() % REFRESH_RATE == 0) {
                        updateJSONData();
                    }
                }
            }
        }.start();

        beginServer(SERVER_PORT);
    }

    /**
     * Performs a call to createJSON to generate a JSON string to display in the HTTP Response
     */
    public void updateJSONData() {
        jsonObject = json.createJSON();
    }

    /**
     * Parses the messages received from the WebServer and returns the appropriate string
     *
     * @param message String containing the HTTP request
     * @return String containing the content of the HTTP response
     */
    public String processMessage(String message) {
        Log.e(TAG, message);

        String[] httpRequest = message.split(" ");

        if (httpRequest[0].equals("GET") && httpRequest[1].equals("/")) {
            String html = context.getString(R.string.default_html_page);
            return setUpHTTPMessage(html, "text/html");

        } else if (httpRequest[0].equals("GET") && httpRequest[1].equals("/status")) {
            return setUpHTTPMessage(jsonObject.toString(), "application/json");

        } else if (httpRequest[0].equals("GET") && httpRequest[1].equals("/status/pretty")) {
            try {
                return setUpHTTPMessage(jsonObject.toString(2), "application/json");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return setUpHTTPMessage(jsonObject.toString(), "application/json");
        }

        String content = context.getString(R.string.error_html_page);
        SimpleDateFormat dateFormat =
                new SimpleDateFormat(context.getString(R.string.date_format), Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone(context.getString(R.string.time_zone)));

        return String.format(
                "%s\r\nDate: %s\r\nContent-Type: text/html\r\nContent-Length: %d\r\n\r\n%s",
                context.getString(R.string.error_page),
                dateFormat.format(new Date()).replace("+00:00", ""),
                content.length(),
                content);
    }

    /**
     * Begin the server, to be implemented in Java instead of C
     *
     * @param port      String containing the port
     */

    public void beginServer(final int port) {

        new Thread() {
            public void run() {
                Socket socket = null;
                BufferedReader is;
                String request;

                try {
                    httpServerSocket = new ServerSocket(port);

                    while (true) {
                        socket = httpServerSocket.accept();

                        is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        request = is.readLine();

                        HttpResponseThread hrt =
                                new HttpResponseThread(
                                        socket,
                                        processMessage(request));

                        hrt.start();
                    }

                } catch (IOException e) {
                    // TODO Auto-generated catch
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * Iterates through the device's IPAddresses and returns first non-local IP address
     *
     * @return String containing the first non-local IP address of the device.
     */
    public String getIPAddress() {
        String ipAddress = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                 en.hasMoreElements(); ) {

                NetworkInterface networkInterface = en.nextElement();

                for (Enumeration<InetAddress> enumIpAddr = networkInterface.getInetAddresses();
                     enumIpAddr.hasMoreElements(); ) {

                    InetAddress inetAddress = enumIpAddr.nextElement();

                    if (!inetAddress.isLoopbackAddress()) {
                        ipAddress = inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }

        return ipAddress;

    }

    /**
     * Formats the message into an HTTP request that is to be sent to the server.
     *
     * @param content      String containing the content of the message
     * @param content_type String containing the "Content-Type"
     * @return String containing the formatted HTTP request message
     */
    public String setUpHTTPMessage(String content, String content_type) {

        SimpleDateFormat dateFormat =
                new SimpleDateFormat(context.getString(R.string.date_format), Locale.US);

        dateFormat.setTimeZone(TimeZone.getTimeZone(context.getString(R.string.time_zone)));

        return String.format(
                "%s\r\nDate: %s\r\nContent-Type: %s\r\nContent-Length: %d\r\n\r\n%s",
                context.getString(R.string.success_page),
                dateFormat.format(new Date()).replace("+00:00", ""),
                content_type,
                content.length(),
                content);
    }

}