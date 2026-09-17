import java.util.Scanner;

public class FoodInsertion {
    static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int count;

        System.out.print("What # of food do you want?: ");
        count = scan.nextInt();
        scan.nextLine();

        String [] food = new String [count];

        for(int i = 0; i < count; i++){
            System.out.print("Enter food: ");
            food[i] = scan.nextLine();
        }

        for (String foods : food){
            System.out.print(foods + " ");
        }
    }
}
