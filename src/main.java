public class Main {
    public static void main(String[] args) {
        // Initialize repositories
        RoomRepository roomRepo = new RoomRepository();
        ReservationRepository reservationRepo = new ReservationRepository();
        GuestRepository guestRepo = new GuestRepository();

        // Initialize logic layer
        ReservationManager reservationManager = new ReservationManager(roomRepo, reservationRepo, guestRepo);
        FeeCalculator feeCalculator = new FeeCalculator(reservationRepo);
        StaffManager staffManager = new StaffManager(reservationRepo, roomRepo);

        // Initialize UI
        TextUI ui = new TextUI(reservationManager, staffManager, feeCalculator);

        // Start the app
        ui.start();
    }
}
