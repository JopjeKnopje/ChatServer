package types;

/**
 * The room where you first sign in
 * other user properties will be set here (nickname, what room to join .etc)
 * The messages wil not be send to all users in this room
 */
public class MainRoom extends Room {

    public MainRoom() {
        super();
    }


    @Override
    public int getId() {
        return super.getId();
    }
}
