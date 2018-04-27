package types;

import java.net.Socket;


public class User {
    private static int id = 0;
    private Socket socket;
    private String username;

    public User(Socket socket) {
        this.socket = socket;
        id++;
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean usernameIsSet() {
        if (username == null) return false;
        return true;
    }


}
