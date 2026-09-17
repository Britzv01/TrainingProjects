import java.util.Scanner;

public class LeapYearChecker {

    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        boolean isRunning = true;

        // add a title
        System.out.println("Leap Year Checker");
        System.out.println("------------------");

        // encase in a loop
        while (isRunning) {
            // initialize variables
            int year;
            int repeat;

            // ask a year
            System.out.print("Enter year: ");
            year = scan.nextInt();
            System.out.println("------------------");
            // check if year is a leap year
            // generate result
            if (year % 400 == 0){
                System.out.println(year + ": is a Century Leap Year");
            }

            else if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(year + ": is a Leap Year");
            }

            else {
                System.out.println(year + ": is not a Leap Year");
            }
            System.out.println("------------------");

            System.out.print("Do you want to try again? [Yes (1) / No (2)]: ");
            repeat = scan.nextInt();
            System.out.println("------------------");

            if (repeat == 2){
                System.out.println("Thank you!");
                break;
            }
        }

        scan.close();
    }
}
