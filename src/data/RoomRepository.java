import java.util.HashMap;

public class RoomRepository {
    private final HashMap<Integer, Boolean> rooms = new HashMap<>();

    public RoomRepository() {
        // Initialize rooms
        rooms.put(101, true);
        rooms.put(102, true);
        rooms.put(103, true);
    }

    public boolean isAvailable(int roomNumber) {
        return rooms.getOrDefault(roomNumber, false);
    }

    public void markAsOccupied(int roomNumber) {
        rooms.put(roomNumber, false);
    }

    public void markAsAvailable(int roomNumber) {
        rooms.put(roomNumber, true);
    }
}
