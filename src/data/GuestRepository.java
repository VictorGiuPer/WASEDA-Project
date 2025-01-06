import java.util.HashMap;

public class GuestRepository {
    private final HashMap<Integer, Guest> guests = new HashMap<>();
    private int nextGuestID = 1;

    public int addGuest(String name, String email, String phone) {
        Guest guest = new Guest(nextGuestID, name, email, phone);
        guests.put(nextGuestID, guest);
        return nextGuestID++;
    }

    public Guest getGuest(int guestID) {
        return guests.get(guestID);
    }
}
