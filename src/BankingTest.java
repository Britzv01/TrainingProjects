import java.util.Scanner;

public class BankingTest {
    static Scanner scan = new Scanner(System.in);
    static double balance = 1000;

    static void checkBalance(){
        System.out.printf("Your balance is $%,.2f\n", balance);
    }

    static void depositCash(){
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scan.nextDouble();

        if (depositAmount <= 0) {
            System.out.println("Invalid Amount! Try Again!");
        }
        else {
            balance += depositAmount;
            checkBalance();
        }
    }

    static void withdrawCash(){
        System.out.print("Enter amount to withdraw: ");
        double withdrawnAmount = scan.nextDouble();
        if (withdrawnAmount > balance){
            System.out.println("Insufficient Amount of Funds! Try Again!");
        }
        else if (withdrawnAmount <= 0){
            System.out.println("Invalid Withdrawal Amount! Try Again");
        }
        else {
            balance -= withdrawnAmount;
            checkBalance();
        }
    }

    public static void main (String [] args) {
        boolean isRunning = true;

        while (isRunning) {
            char choice;
            System.out.println("\t\nBANKING PROGRAM");
            System.out.print("""
                    1. Show Balance
                    2. Deposit 
                    3. Withdraw
                    4. Exit
                    """);
            System.out.println("**************");
            System.out.print("Enter your choice (1-4): ");
            choice = scan.next().charAt(0);

            switch (choice) {
                case '1' -> checkBalance();
                case '2' -> depositCash();
                case '3' -> withdrawCash();
                case '4' -> {
                    System.out.print("Thank you! Come again!");
                    isRunning = false;
                }
                default -> System.out.println("INVALID INPUT!");
            }
        }
        scan.close();
    }
}
