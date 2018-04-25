package types;

import java.net.Socket;

public class User {

    private Socket socket;
    // list with pools the user is in

    public User(Socket socket) {
        this.socket = socket;

    }
}
