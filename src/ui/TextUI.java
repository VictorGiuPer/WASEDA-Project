import java.util.Scanner;

public class TextUI {
    private final ReservationManager reservationManager;
    private final StaffManager staffManager;
    private final FeeCalculator feeCalculator;

    public TextUI(ReservationManager reservationManager, StaffManager staffManager, FeeCalculator feeCalculator) {
        this.reservationManager = reservationManager;
        this.staffManager = staffManager;
        this.feeCalculator = feeCalculator;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Hotel Reservation System!");
        // Basic text menu
        while (true) {
            System.out.println("\n1. Create Reservation");
            System.out.println("2. Check-In");
            System.out.println("3. Check-Out");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createReservation(scanner);
                case 2 -> checkIn(scanner);
                case 3 -> checkOut(scanner);
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void createReservation(Scanner scanner) {
        // Simple interaction logic for reservation
        System.out.print("Enter guest name: ");
        String name = scanner.next();
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter phone number: ");
        String phone = scanner.next();
        System.out.print("Enter desired room number: ");
        int roomNumber = scanner.nextInt();

        reservationManager.createReservation(name, email, phone, roomNumber);

        // Calculate total cost using FeeCalculator
        double basePrice = 100.00; // Example base price
        double addOns = 20.00; // Example add-ons
        ReservationSummary summary = new ReservationSummary(name, email, phone, roomNumber, basePrice, addOns);
        summary.displaySummary();
    }

    private void checkIn(Scanner scanner) {
        System.out.print("Enter reservation ID: ");
        int reservationID = scanner.nextInt();

        if (staffManager.checkIn(reservationID)) {
            System.out.println("Check-in successful!");
        } else {
            System.out.println("Check-in failed. Reservation not found or invalid.");
        }
    }

    private void checkOut(Scanner scanner) {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();

        double fee = staffManager.checkOut(roomNumber);
        if (fee >= 0) {
            System.out.println("Check-out successful! Total fee: $" + fee);
        } else {
            System.out.println("Check-out failed. Room not found or not checked-in.");
        }
    }
}
