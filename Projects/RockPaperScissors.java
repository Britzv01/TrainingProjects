import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        String [] computerChoices = {"ROCK", "PAPER", "SCISSORS"};

        System.out.println("Rock, Paper, Scissors Game!");

        while(true) {
            String userGuess;

            while(true) {
                System.out.println("---------------------------");
                System.out.println("[Rock/Paper/Scissor]");
                System.out.print("Enter your move: ");
                userGuess = scan.nextLine().toUpperCase();

                if (!userGuess.equals("ROCK") && !userGuess.equals("PAPER") && !userGuess.equals("SCISSORS")){
                    System.out.println("INVALID CHOICE!");
                    continue;
                }

                break;
            }

            int randomValue = random.nextInt(computerChoices.length);
            String computerChoice = computerChoices[randomValue];
            System.out.println("Computer Choice: " + computerChoice);
            System.out.println("---------------------------");

            if (userGuess.equals(computerChoice)){
                System.out.println("Tie!");
            }

            else if((userGuess.equals("ROCK") && computerChoice.equals("PAPER")) || (userGuess.equals("PAPER") && computerChoice.equals("SCISSORS")) || (userGuess.equals("SCISSORS") && computerChoice.equals("ROCK"))) {
                System.out.println("You Lose!");
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
