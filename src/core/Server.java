package core;

import config.STATICS;

import java.io.IOException;

public class Server {

    private final boolean running = true;

    private int port = 5555;


    public Server() {

        Listener listener = new Listener(STATICS.PORT);
        // Start the listener
        Thread listenerThread = new Thread(listener);
        listenerThread.start();

        ClientHandler clientHandler = new ClientHandler(listener);
        try {
            clientHandler.handle();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // blocks the main thread until the thread has finished
        try {
            listenerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread() + " ended");

    }



}
