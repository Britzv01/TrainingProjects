import java.util.Scanner;

public class ArraySearch {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        String [] cars = {"Mazda", "Toyota", "Honda", "Mitsubishi"};
        boolean isFound = false;
        String target;

        System.out.print("Enter a car to search for: ");
        target = scan.nextLine();

        for (int i = 0; i < cars.length; i++){
            if (cars[i].toLowerCase().equalsIgnoreCase(target)){
                System.out.println("Element found at index: " + i);
                isFound = true;
                break;
            }
        }

        if (!isFound){
            System.out.println("Element does not exist!");
        }
    }
}
