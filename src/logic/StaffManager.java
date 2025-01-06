public class StaffManager {
    private final ReservationRepository reservationRepo;
    private final RoomRepository roomRepo;

    public StaffManager(ReservationRepository reservationRepo, RoomRepository roomRepo) {
        this.reservationRepo = reservationRepo;
        this.roomRepo = roomRepo;
    }

    public boolean checkIn(int reservationID) {
        return reservationRepo.updateStatus(reservationID, "Checked-In");
    }

    public double checkOut(int roomNumber) {
        int reservationID = roomRepo.getReservationForRoom(roomNumber);
        if (reservationID != -1) {
            double fee = reservationRepo.calculateFee(reservationID);
            reservationRepo.updateStatus(reservationID, "Checked-Out");
            return fee;
        }
        return -1;
    }
}
