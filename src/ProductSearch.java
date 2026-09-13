import java.util.Scanner;

public class ProductSearch {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        String [] items = {"Milk", "Eggs", "Bread", "Butter", "Margarine", "Safe Guard"};
        int [] itemQuantity = {4, 8, 10, 0, 9, 10};
        boolean isFound = false;

        System.out.println("Inventory List:");
        for (int k = 0; k < items.length; k++){
            System.out.printf("Product: %s | Quantity: %d%n", items[k], itemQuantity[k]);
        }
        System.out.println("--------------------------");


        System.out.print("What item would you like to buy? : ");
        String searchTarget = scan.nextLine().replace(" ", "");
        System.out.println("--------------------------");


        for (int i = 0; i < items.length; i++){
            if (searchTarget.equalsIgnoreCase(items[i].replace(" ", ""))){
                System.out.println("Product Found!");
                System.out.println("--------------------------");
                System.out.printf("Product: %s | Quantity: %d%n", items[i], itemQuantity[i]);
                if (itemQuantity[i] <= 0){
                    System.out.println("Insufficient Stocks! Try Again");
                }
                else {
                    itemQuantity[i] -= 1;
                }
                isFound = true;
                break;
            }
        }

        if (!isFound){
            System.out.println("Item not found in inventory!");
        }

        else if (isFound) {
            System.out.println("-------------------------");
            System.out.println("Updated Inventory List: ");
            for (int j = 0; j < items.length; j++) {
                System.out.printf("Product: %s | Quantity: %d%n", items[j], itemQuantity[j]);
            }
        }

        scan.close();
    }
}



