package types;


import java.util.ArrayList;

/**
 * Contains clients
 * Has method to read and send messages
 */
public abstract class Room {
    private static int id = 0;
    private ArrayList<User> users = new ArrayList<>();


    public Room() {
        id++;
    }






    public ArrayList<User> getUsers() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }

    public int getId() {
        return id;
    }
}
