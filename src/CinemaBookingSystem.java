import java.util.Scanner;

public class CinemaBookingSystem {
    static boolean [] cinemaSeats = {true, false , false, false, true, false, true, true, true, false};
    static Scanner scan = new Scanner(System.in);

    static void viewSeats(){
        for (int i = 0; i < cinemaSeats.length; i++){
            String seatStatus = !cinemaSeats[i]? "Available" : "Booked";
            System.out.printf("Seat %d: [%s]%n", (i + 1), seatStatus);
        }
    }

    static void bookSeat(){
        while(true) {
            System.out.print("Enter Seat #[1-10]: ");
            int seatNumber = scan.nextInt();
            System.out.println("---------------------");

            if(seatNumber > cinemaSeats.length || seatNumber < 1){
                System.out.println("Invalid Seat Number!");
                System.out.println("---------------------");
            }

            else {
                if (!cinemaSeats[seatNumber - 1]) {
                    cinemaSeats[seatNumber - 1] = true;
                    System.out.println("Booking Complete!");
                    break;

                }

                else {
                    System.out.println("Seat Taken! Choose Again!");
                    System.out.println("---------------------");
                }
            }
        }
    }

    static void cancelBook(){
        while(true) {
            System.out.print("Enter Seat #[1-10]: ");
            int seatNumber = scan.nextInt();
            System.out.println("---------------------");

            if(seatNumber > cinemaSeats.length || seatNumber < 1){
                System.out.println("Invalid Seat Number!");
                System.out.println("---------------------");
            }

            else {
                if (cinemaSeats[seatNumber - 1]) {
                    cinemaSeats[seatNumber - 1] = false;
                    System.out.println("Cancel Booking Complete!");
                    break;
                }

                else {
                    System.out.println("Seat Available! Cancellation is Unnecessary");
                    System.out.println("---------------------");

                }
            }
        }
    }

    public static void main(String [] args){
        int choice;
        boolean isRunning = true;

        System.out.println("Cinema Booking System");
        System.out.println("---------------------");

        while(isRunning) {
            System.out.print("""
                    [1] - View Seats
                    [2] - Book Seat/s
                    [3] - Cancel Booking
                    [4] - Exit
                    """);
            System.out.print(": ");
            choice = scan.nextInt();
            System.out.println("---------------------");

            switch (choice) {
                case 1 -> viewSeats();
                case 2 -> bookSeat();
                case 3 -> cancelBook();
                case 4 -> {
                    System.out.println("Thank You!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid Choice");
            }
            System.out.println("---------------------");
        }
        scan.close();
    }
}
