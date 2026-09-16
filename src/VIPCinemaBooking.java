import java.util.Scanner;

public class VIPCinemaBooking {
    Scanner scan = new Scanner(System.in);
    String [] cinemaSeats = new String[10];

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
            }

            else if (!cinemaSeats[seatNumber].equals("Empty")){
                System.out.println("Seat Taken! Choose Again!");
                System.out.println("---------------------");
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
            System.out.print("Enter Seat #[1-10]: ");
            int seatNumber = scan.nextInt();
            System.out.println("---------------------");

            if (seatNumber > cinemaSeats.length || seatNumber < 1) {
                System.out.println("Invalid Seat Number!");
                System.out.println("---------------------");
            }

            else if (!cinemaSeats[seatNumber].equals("Empty")) {
                System.out.println("Seat Available! Cancellation is Unnecessary");
                System.out.println("---------------------");
            }

            cinemaSeats[seatNumber - 1] = "Empty";
            System.out.println("Cancel Booking Complete!");
            break;
        }
    }

    public static void main (String[]args){
        VIPCinemaBooking app = new VIPCinemaBooking();
        int choice;
        boolean isRunning = true;

        System.out.println("Cinema Booking System");
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
