package core;

import config.STATICS;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private ServerSocket serverSocket;
    private Thread listener;


    public Server() {
        try {
            serverSocket = new ServerSocket(STATICS.PORT);

            // Time between the accept and being accepted
//            serverSocket.setSoTimeout(STATICS.TIMEOUT_TIME);


            // Start listener thread
            listener = new Listener(serverSocket);
            listener.start();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
