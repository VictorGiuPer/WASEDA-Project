public class CalendarView {
    private final RoomRepository roomRepo;

    public CalendarView(RoomRepository roomRepo) {
        this.roomRepo = roomRepo;
    }

    public void displayAvailability() {
        System.out.println("Room Availability:");
        for (int roomNumber : roomRepo.getAllRooms().keySet()) {
            boolean available = roomRepo.isAvailable(roomNumber);
            System.out.println("Room " + roomNumber + ": " + (available ? "Available" : "Occupied"));
        }
    }
}
