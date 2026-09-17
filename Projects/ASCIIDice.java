import java.util.Random;
import java.util.Scanner;

public class ASCIIDice {
    static Random dice = new Random();

    static void printDice(int roll) throws InterruptedException {
        String dice1 = """
                --------
               |        |
               |   •    |
               |        |
                --------
                """;

        String dice2 = """
                --------
               | •      |
               |        |
               |      • |
                --------
                """;

        String dice3 = """
                --------
               | •      |
               |   •    |
               |     •  |
                --------
                """;

        String dice4 = """
                --------
               | •    • |
               |        |
               | •    • |
                --------
                """;

        String dice5 = """
                --------
               | •    • |
               |    •   |
               | •    • |
                --------
                """;

        String dice6 = """
                --------
               | •    • |
               | •    • |
               | •    • |
                --------
                """;

        String [] arrDice = {dice1, dice2, dice3, dice4, dice5, dice6};

        for (int j = 0; j < 3; j++){
            Thread.sleep(500);
            System.out.print(arrDice[dice.nextInt(0,6)]);
        }

        switch(roll){
            case 1 -> System.out.println(dice1);
            case 2 -> System.out.println(dice2);
            case 3 -> System.out.println(dice3);
            case 4 -> System.out.println(dice4);
            case 5 -> System.out.println(dice5);
            case 6 -> System.out.println(dice6);
        }
    }

    public static void main (String [] args) throws InterruptedException {
        //Ask for user input
        Scanner scan = new Scanner(System.in);

        int numRoll, total = 0, roll;
        boolean status = true;

            System.out.print("Enter the # of dice to roll: ");
            numRoll = scan.nextInt();

            if (numRoll < 0) {
                System.out.println("# of dice must be greater than 0");
            }
            else {
                for(int i = 0; i < numRoll; i++){
                    roll = dice.nextInt(1, 7);
                    System.out.println("You rolled: " + roll);
                    Thread.sleep(1000);
                    printDice(roll);
                    total += roll;
                }
                System.out.print("Your total roll is " + total);
            }

        scan.close();
    }
}
