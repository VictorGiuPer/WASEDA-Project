public class FeeCalculator {
    private final ReservationRepository reservationRepo;

    public FeeCalculator(ReservationRepository reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public double calculateFee(int reservationID) {
        // Get reservation details
        Reservation reservation = reservationRepo.getReservation(reservationID);
        if (reservation == null) {
            return -1; // Error: Reservation not found
        }

        double basePrice = reservation.getBasePrice();
        double addOns = reservation.getAddOns();

        return basePrice + addOns;
    }
}
