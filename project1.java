import java.util.*;

public class project1 {

    // Room class to manage individual room details
    static class Room {
        int roomNumber;
        String type;
        boolean isAvailable;

        Room(int roomNumber, String type, boolean isAvailable) {
            this.roomNumber = roomNumber;
            this.type = type;
            this.isAvailable = isAvailable;
        }

        void displayDetails() {
            System.out.printf("Room %d (%s): %s\n", roomNumber, type, (isAvailable ? "Available" : "Occupied"));
        }
    }

    // Guest class to manage guest details
    static class Guest {
        String name;
        String contact;

        Guest(String name, String contact) {
            this.name = name;
            this.contact = contact;
        }

        void displayDetails() {
            System.out.printf("Name: %s, Contact: %s\n", name, contact);
        }
    }

    // Reservation class to manage reservations
    static class Reservation {
        Room room;
        Guest guest;
        Date checkInDate;
        Date checkOutDate;

        Reservation(Room room, Guest guest, Date checkInDate, Date checkOutDate) {
            this.room = room;
            this.guest = guest;
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
        }

        void displayDetails() {
            System.out.printf("Room %d reserved by %s from %s to %s\n", room.roomNumber, guest.name, checkInDate, checkOutDate);
        }
    }

    static class Hotel {
        private final List<Room> rooms = new ArrayList<>();
        private final List<Reservation> reservations = new ArrayList<>();

        void addRoom(int roomNumber, String type) {
            rooms.add(new Room(roomNumber, type, true));
            System.out.printf("Added Room %d (%s)\n", roomNumber, type);
        }

        void listRooms() {
            System.out.println("Listing all rooms:");
            for (Room room : rooms) {
                room.displayDetails();
            }
        }

        Room findRoom(int roomNumber) {
            for (Room room : rooms) {
                if (room.roomNumber == roomNumber) return room;
            }
            return null;
        }

        void reserveRoom(int roomNumber, String guestName, String guestContact, Date checkIn, Date checkOut) {
            Room room = findRoom(roomNumber);
            if (room == null) {
                System.out.println("Room not found.");
                return;
            }

            if (!room.isAvailable) {
                System.out.println("Room is not available.");
                return;
            }

            Guest guest = new Guest(guestName, guestContact);
            Reservation reservation = new Reservation(room, guest, checkIn, checkOut);
            reservations.add(reservation);
            room.isAvailable = false;
            System.out.printf("Room %d has been reserved by %s.\n", roomNumber, guestName);
        }

        void cancelReservation(int roomNumber) {
            Iterator<Reservation> iterator = reservations.iterator();
            while (iterator.hasNext()) {
                Reservation reservation = iterator.next();
                if (reservation.room.roomNumber == roomNumber) {
                    iterator.remove();
                    reservation.room.isAvailable = true;
                    System.out.printf("Reservation for Room %d has been canceled.\n", roomNumber);
                    return;
                }
            }
            System.out.println("No reservation found for the room.");
        }

        void listReservations() {
            System.out.println("Listing all reservations:");
            for (Reservation reservation : reservations) {
                reservation.displayDetails();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("1. Add Room");
            System.out.println("2. List Rooms");
            System.out.println("3. Reserve Room");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. List Reservations");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter room type: ");
                    String type = scanner.nextLine();
                    hotel.addRoom(roomNumber, type);
                    break;

                case 2:
                    hotel.listRooms();
                    break;

                case 3:
                    System.out.print("Enter room number to reserve: ");
                    roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter guest contact: ");
                    String guestContact = scanner.nextLine();
                    System.out.print("Enter check-in date (yyyy-mm-dd): ");
                    Date checkIn = new GregorianCalendar(scanner.nextInt(), scanner.nextInt() - 1, scanner.nextInt()).getTime();
                    System.out.print("Enter check-out date (yyyy-mm-dd): ");
                    Date checkOut = new GregorianCalendar(scanner.nextInt(), scanner.nextInt() - 1, scanner.nextInt()).getTime();
                    hotel.reserveRoom(roomNumber, guestName, guestContact, checkIn, checkOut);
                    break;

                case 4:
                    System.out.print("Enter room number to cancel reservation: ");
                    roomNumber = scanner.nextInt();
                    hotel.cancelReservation(roomNumber);
                    break;

                case 5:
                    hotel.listReservations();
                    break;

                case 6:
                    System.out.println("Exiting Hotel Management System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
