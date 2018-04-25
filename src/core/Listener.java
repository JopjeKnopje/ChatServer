package core;

import types.User;
import util.BytesUtil;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Listener extends Thread {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private static ArrayList<User> sockets = new ArrayList<>();


    public Listener(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;

    }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for clientSocket on port: " + serverSocket.getLocalPort());
                clientSocket = serverSocket.accept();

                DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());

                int length = dataInputStream.readInt();                    // read length of incoming message

                if(length>0) {
                    byte[] message = new byte[length];
                    dataInputStream.readFully(message, 0, message.length); // read the message
                    System.out.println(message);
                }



            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
