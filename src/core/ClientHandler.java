package core;

import config.STATICS;
import types.ChatRoom;
import types.Room;
import types.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Handles all the connections
 */
public class ClientHandler {

    private Listener listener;
    private Room[] rooms = new Room[STATICS.MAX_ROOMS];


    public ClientHandler(Listener listener) {
        this.listener = listener;

        // Setup the chat rooms
        for (int i = 0; i < STATICS.MAX_ROOMS; i++) {
            ChatRoom room = new ChatRoom();
            rooms[i] = room;
        }
        System.out.println("Rooms created");
    }


    public void handle() throws IOException {
        while (true) {

            // loop through all the rooms
            for (int i = 0; i < STATICS.MAX_ROOMS; i++) {
                ArrayList<User> tmp = rooms[i].getUsers(); // store user in tmp
                System.out.println(tmp);
                // loop through all the users open stream and read messages if there are any
                for (int j = 0; j < tmp.size(); j++) {

                    InputStream in = tmp.get(j).getSocket().getInputStream();

                    int toRead = in.available(); // returns the amount of available bytes

                    if (toRead > 0) { // if there is any data to read, read it

                        byte[] buffer = new byte[toRead];
                        in.read(buffer); // read the data
                        System.out.println(buffer);
                        // Send the message to all other clients
                        for (int k = 0; k < tmp.size(); k++) {
                            OutputStream out = tmp.get(k).getSocket().getOutputStream();
                            out.write(buffer);
                            out.flush();
                        }
                    }
                    else {
                        System.out.println("Nothing to read");
                    }
                }
            }

            // if there are no messages check for a new user


            // add new user to default room

            
            // TODO rewrite
            // have the user contain the room they are in
            // so you can access all the users in one array instead of this shit

        }
    }

}
