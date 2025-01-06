import java.util.HashMap;

public class ReservationRepository {
    private final HashMap<Integer, Reservation> reservations = new HashMap<>();
    private int nextID = 1;

    public int addReservation(String name, String email, String phone, int roomNumber) {
        Reservation reservation = new Reservation(nextID, name, email, phone, roomNumber);
        reservations.put(nextID, reservation);
        return nextID++;
    }

    public Reservation getReservation(int reservationID) {
        return reservations.get(reservationID);
    }

    public boolean updateStatus(int reservationID, String status) {
        Reservation reservation = reservations.get(reservationID);
        if (reservation != null) {
            reservation.setStatus(status);
            return true;
        }
        return false;
    }
}
