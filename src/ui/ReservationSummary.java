public class ReservationSummary {
    private final String guestName;
    private final String email;
    private final String phone;
    private final int roomNumber;
    private final double basePrice;
    private final double addOns;
    private final double totalCost;

    public ReservationSummary(String guestName, String email, String phone, int roomNumber, double basePrice, double addOns) {
        this.guestName = guestName;
        this.email = email;
        this.phone = phone;
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.addOns = addOns;
        this.totalCost = basePrice + addOns;
    }

    public void displaySummary() {
        System.out.println("\n--- Reservation Summary ---");
        System.out.println("Guest Name: " + guestName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Base Price: $" + basePrice);
        System.out.println("Add-Ons: $" + addOns);
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("---------------------------");
    }
}
