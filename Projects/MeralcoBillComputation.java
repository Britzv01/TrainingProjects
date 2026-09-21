import java.util.Scanner;

public class MeralcoBillComputation {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        int previousRead;
        int currentRead;
        double kWh;
        double computedBill;

        System.out.println("Meralco Bill Calculator");
        System.out.println("-----------------------");

        System.out.print("Enter initial read: ");
        previousRead = scan.nextInt();
        System.out.println("-----------------------");

        System.out.print("Enter recent read: ");
        currentRead = scan.nextInt();
        System.out.println("-----------------------");

        System.out.print("Enter kilowatts per hour: ");
        kWh = scan.nextDouble();
        System.out.println("-----------------------");

        computedBill = (previousRead - currentRead) * kWh;

        System.out.printf("Total Bill: ₱%,.2f", Math.abs(computedBill));
    }
}
