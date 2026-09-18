import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        String [] computerChoices = {"ROCK", "PAPER", "SCISSORS"};
        String guess;


        System.out.println("Rock, Paper, Scissors Game!");

        while(true) {
            int randomValue = random.nextInt(0, 3);
            String computerChoice = computerChoices[randomValue];

            System.out.println("---------------------------");
            System.out.println("[Rock/Paper/Scissor]");
            System.out.print("Enter your move: ");
            guess = scan.nextLine().toUpperCase();
            System.out.println("Computer Choice: " + computerChoice);
            System.out.println("---------------------------");


            if((guess.equals("ROCK") && computerChoice.equals("PAPER")) || (guess.equals("PAPER") && computerChoice.equals("SCISSORS")) || (guess.equals("SCISSORS") && computerChoice.equals("ROCK"))) {
                System.out.println("You Lose!");
            }

            else if (guess.equals(computerChoice)){
                System.out.println("Tie!");
            }
            else {
                System.out.println("You Win!");
            }

            System.out.println("---------------------------");


            System.out.print("Play Again? [Yes] / [No]: ");
            String replay = scan.nextLine().toUpperCase();

            if (replay.equals("NO")){
                System.out.println("---------------------------");
                System.out.println("Thank you! Try Again!");
                break;
            }
        }
        scan.close();
    }
}
