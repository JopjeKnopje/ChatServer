package core;

import config.STATICS;
import types.ChatRoom;
import types.Room;
import types.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Handles all the connections
 */
public class ClientHandler {

    private Listener listener;
    private Room[] rooms = new Room[STATICS.MAX_ROOMS];
    private HashMap<User, Room> userRoom  = new HashMap<>();
    private Queue<User> userQueue = new LinkedList<>();


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

            // check for a new user
            if(queueHasNext(userQueue)) {
                // get the new user
                User tmp = userQueue.poll();

                // add user to default room
                userRoom.put(tmp, rooms[STATICS.ROOM_DEFAULT]);


            }

            // add new user to default room

            // loop through rooms

            // check for new messages

            // TODO rewrite
            // have the user contain the room they are in
            // so you can access all the users in one array instead of this shit

        }
    }


    public boolean queueHasNext(Queue queue) {
        if(queue.peek() != null) return false;


    }

}
