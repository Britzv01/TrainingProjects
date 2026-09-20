import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    String [] slotItems = {"🍒", "🍉", "🍋", "🔔", "⭐️"};
    String [] slotResults = new String[3];
    int balance;
    int bet;

    public SlotMachine(){
        this.balance = 100;
    }

    void printBalance(){
        System.out.println("-------------------------");
        System.out.println("Current Balance: $" + balance);
    }

    void placeBet(){
        while(true) {
            System.out.println("-------------------------");
            System.out.print("Place Bet Amount: $");
            bet = scan.nextInt();
            scan.nextLine();

            if (bet > balance || bet < 1) {
                System.out.println("-------------------------");
                System.out.println("Invalid Amount!");
                continue;
            }

            break;
        }
        balance -= bet;
    }

    void spinRoulette(){
        System.out.println("-------------------------");
        System.out.println("Spinning...");

        System.out.println("-------------------------");
        for(int i = 0; i < 3; i++){
            slotResults[i] = slotItems[random.nextInt(slotItems.length)];
            System.out.print(slotResults[i] + " | ");
        }
        System.out.println("\n-------------------------");
    }

    void payout(){
        int multipliedBet;
        if(slotResults[0].equals(slotResults [1]) && slotResults[1].equals(slotResults[2])){
            multipliedBet =  bet * 3;
            balance += multipliedBet;
            System.out.println("You Won: $" + multipliedBet);

        }
        else if ((slotResults[0].equals(slotResults[1])) || (slotResults[1].equals(slotResults[2])) || (slotResults[2].equals(slotResults[0]))){
            multipliedBet =  bet * 2;
            balance += multipliedBet;
            System.out.println("You Won: $" + multipliedBet);
        }

        else {
            System.out.println("You Lost This Round!");
        }
        System.out.println("-------------------------");

    }

    public static void main(String [] args) {
        SlotMachine slot = new SlotMachine();
        String choice;

        System.out.println("Slot Machine");
        do {
            slot.printBalance();
            slot.placeBet();
            slot.spinRoulette();
            slot.payout();

            System.out.print("Play Again? [Yes / No]: ");
            choice = slot.scan.nextLine().toLowerCase();

            if(choice.equals("no")){
                System.out.println("-------------------------");
                System.out.println("GAME OVER! Final Balance: $" + slot.balance);
                break;
             }

            if(slot.balance == 0){
                System.out.println("-------------------------");
                System.out.println("Sorry Balance is Insufficent!");
                break;
            }
        } while (choice.equals("yes"));
    }
}