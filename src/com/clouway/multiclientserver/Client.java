package com.clouway.multiclientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Client {
    private final String hostName;
    private final int port;
    private final Display display;

    public Client(String hostName, int port, Display display) {
        this.hostName = hostName;
        this.port = port;
        this.display = display;
    }

    public void connect() {
        try {
            Socket socket = new Socket(hostName, port);
            String receivedMessage;
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while ((receivedMessage = in.readLine()) != null) {
                display.setMessage(receivedMessage);
            }
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to ");
        }
    }
}
