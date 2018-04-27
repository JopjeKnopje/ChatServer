package core;

import types.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Waits for connection and add it to collection
 * TODO: Properly close connection
 */
public class Listener implements Runnable {

    ServerSocket serverSocket;
    int port;
    private ArrayList<User> clients = new ArrayList<>();
    private boolean listening = true;

    public Listener(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Socket connection;
        while (listening) {
            try {
                // Wait for a connection
                connection = serverSocket.accept();
                // Debug message
                System.out.println("New connection from: " + connection.getInetAddress());

                // Add new user to client list
                // TODO: Add user to queue to be processed by the clienthandler
                User user = new User(connection);
                clients.add(user);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<User> getClients() {
        return clients;
    }
}
