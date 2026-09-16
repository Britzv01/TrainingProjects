import java.util.Scanner;

public class VIPCinemaBooking {
    private Scanner scan = new Scanner(System.in);
    private String [] cinemaSeats = new String[10];

    public VIPCinemaBooking(){
        for (int k = 0; k < cinemaSeats.length; k++){
            cinemaSeats[k] = "Empty";
        }
    }

    void viewSeats(){
        for (int i = 0; i < cinemaSeats.length; i++){
            String seatStatus = cinemaSeats[i].equals("Empty")? "Available" : "Booked by: " + cinemaSeats[i];
            System.out.printf("Seat %d: [%s]%n", (i + 1), seatStatus);
        }
    }

    void bookSeat(){
        while(true) {
            System.out.print("Enter Seat #[1-10]: ");
            int seatNumber = scan.nextInt();
            scan.nextLine();
            System.out.println("---------------------");

            if(seatNumber > cinemaSeats.length || seatNumber < 1){
                System.out.println("Invalid Seat Number!");
                System.out.println("---------------------");
                continue;
            }

            else if (!cinemaSeats[seatNumber - 1].equals("Empty")){
                System.out.println("Seat Taken! Choose Again!");
                System.out.println("---------------------");
                continue;
            }

            System.out.print("Enter Guest Name: ");
            String guestName = scan.nextLine();
            System.out.println("---------------------");

            cinemaSeats[seatNumber - 1] = guestName;
            System.out.println("Booking Complete!");
            break;
        }
    }

    void cancelBook() {
        while (true) {
            int seatCounter = 0;

            for (int j = 0; j < cinemaSeats.length; j++){
                if (cinemaSeats[j].equals("Empty")){
                    seatCounter++;
                }
            }

            if (seatCounter == cinemaSeats.length) {
                System.out.println("All Seats are Available! Cancellation is Unnecessary");
                break;
            }

            System.out.print("Enter Seat #[1-10]: ");
            int seatNumber = scan.nextInt();
            scan.nextLine();
            System.out.println("---------------------");

            if (seatNumber > cinemaSeats.length || seatNumber < 1) {
                System.out.println("Invalid Seat Number!");
                System.out.println("---------------------");
                continue;

            }

            else if (cinemaSeats[seatNumber - 1].equals("Empty")) {
                System.out.println("Seat Available! Cancellation is Unnecessary");
                System.out.println("---------------------");
                continue;
            }

            System.out.printf("Cancel Booking Complete for %s!%n", cinemaSeats[seatNumber - 1]);
            cinemaSeats[seatNumber - 1] = "Empty";
            break;
        }
    }

    public static void main (String[]args){
        VIPCinemaBooking app = new VIPCinemaBooking();
        int choice;
        boolean isRunning = true;

        System.out.println("VIP Cinema Booking System");
        System.out.println("---------------------");

        while (isRunning) {
            System.out.print("""
                    [1] - View Seats
                    [2] - Book Seat/s
                    [3] - Cancel Booking
                    [4] - Exit
                    """);
            System.out.print(": ");
            choice = app.scan.nextInt();
            System.out.println("---------------------");

            switch (choice) {
                case 1 -> app.viewSeats();
                case 2 -> app.bookSeat();
                case 3 -> app.cancelBook();
                case 4 -> {
                    System.out.println("Thank You!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid Choice");
            }
            System.out.println("---------------------");
        }
        app.scan.close();
    }
}
