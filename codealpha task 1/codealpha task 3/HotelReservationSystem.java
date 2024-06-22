import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean isAvailable;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true;
    }
}

class Reservation {
    int roomNumber;
    String customerName;
    String category;
    double price;

    Reservation(int roomNumber, String customerName, String category, double price) {
        this.roomNumber = roomNumber;
        this.customerName = customerName;
        this.category = category;
        this.price = price;
    }
}

public class HotelReservationSystem {
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        initializeRooms();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation(sc);
                    break;
                case 3:
                    viewBookingDetails(sc);
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    static void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Single"));
        rooms.add(new Room(201, "Double"));
        rooms.add(new Room(202, "Double"));
        rooms.add(new Room(301, "Suite"));
        rooms.add(new Room(302, "Suite"));
    }

    static void searchAvailableRooms() {
        System.out.println("Available rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println("Room number: " + room.roomNumber + ", Category: " + room.category);
            }
        }
    }

    static void makeReservation(Scanner sc) {
        System.out.println("Enter room number to book:");
        int roomNumber = sc.nextInt();
        sc.nextLine(); // Consume newline
        Room room = findRoomByNumber(roomNumber);

        if (room == null || !room.isAvailable) {
            System.out.println("Room not available.");
            return;
        }

        System.out.println("Enter your name:");
        String customerName = sc.nextLine();
        double price = processPayment(sc, room.category);
        reservations.add(new Reservation(roomNumber, customerName, room.category, price));
        room.isAvailable = false;
        System.out.println("Reservation successful for Room " + roomNumber);
    }

    static void viewBookingDetails(Scanner sc) {
        System.out.println("Enter your name to view booking details:");
        String customerName = sc.nextLine();
        boolean found = false;
        
        for (Reservation res : reservations) {
            if (res.customerName.equalsIgnoreCase(customerName)) {
                System.out.println("Room number: " + res.roomNumber + ", Category: " + res.category + ", Price: $" + res.price);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No reservations found for " + customerName);
        }
    }

    static Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                return room;
            }
        }
        return null;
    }

    static double processPayment(Scanner sc, String category) {
        double price = 0;
        switch (category) {
            case "Single":
                price = 100;
                break;
            case "Double":
                price = 150;
                break;
            case "Suite":
                price = 250;
                break;
        }
        System.out.println("The price for " + category + " room is $" + price);
        System.out.println("Enter payment amount:");
        double payment = sc.nextDouble();
        
        while (payment < price) {
            System.out.println("Insufficient payment. Please enter at least $" + price);
            payment = sc.nextDouble();
        }
        
        System.out.println("Payment successful.");
        return price;
    }
}
