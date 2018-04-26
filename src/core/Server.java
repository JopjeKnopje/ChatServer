package core;

import config.STATICS;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final boolean running = true;
    private ServerSocket serverSocket;
    private Thread listener;


    public Server() {
        try {
            serverSocket = new ServerSocket(STATICS.PORT); // Listening socket
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listen() {
        try {
            while (running) {
                Socket connectionSocket = serverSocket.accept(); // get the connectionSocket
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
