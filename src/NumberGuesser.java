import java.util.Scanner;
import java.util.Random;

public class NumberGuesser {
    public static void main (String [] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Number Guesser Game");
        System.out.println("--------------------");

        while(true) {
            int randomNumber;
            int counter = 1;

            System.out.println("Generating random number...");
            randomNumber = random.nextInt(1, 100);
            Thread.sleep(1000);

            while (true) {
                int guessedNumber;

                System.out.println("--------------------");
                System.out.print("Enter your guess: ");
                guessedNumber = scan.nextInt();
                System.out.println("--------------------");

                if (guessedNumber > randomNumber) {
                    System.out.println("Too High!");
                    counter++;
                } else if (guessedNumber < randomNumber) {
                    System.out.println("Too Low!");
                    counter++;
                } else {
                    System.out.println("Congratulations! You guessed '" + randomNumber + "' correctly!");
                    System.out.println("# of Attempts: " + counter);
                    System.out.println("--------------------");
                    break;
                }
            }

            System.out.println("Play Again? [1] - Yes / [2] No");
            System.out.print(": ");
            int replay = scan.nextInt();
            System.out.println("--------------------");

            if (replay == 2){
                System.out.println("Thank you! Try Again Sometime!");
                break;
            }
        }
        scan.close();
    }
}
