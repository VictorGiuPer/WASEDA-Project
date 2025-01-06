public class ReservationManager {
    private final RoomRepository roomRepo;
    private final ReservationRepository reservationRepo;
    private final GuestRepository guestRepo;

    public ReservationManager(RoomRepository roomRepo, ReservationRepository reservationRepo, GuestRepository guestRepo) {
        this.roomRepo = roomRepo;
        this.reservationRepo = reservationRepo;
        this.guestRepo = guestRepo;
    }

    public void createReservation(String name, String email, String phone, int roomNumber) {
        // Logic to create reservation
        if (roomRepo.isAvailable(roomNumber)) {
            int reservationID = reservationRepo.addReservation(name, email, phone, roomNumber);
            System.out.println("Reservation ID: " + reservationID);
        } else {
            System.out.println("Room not available.");
        }
    }
}
