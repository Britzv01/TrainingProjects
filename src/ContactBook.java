import java.util.Scanner;

public class ContactBook {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        String [] names = {"Onycah Negrido", "Ella", "Rhemier", "Mary", "Trisha"};
        String targetName;
        boolean isFound = false;

        System.out.println("Contact Book Search");
        System.out.println("-------------------");

        while(true) {

            System.out.print("Search for name: ");
            targetName = scan.nextLine().trim();
            System.out.println("-------------------");

            for (int i = 0; i < names.length; i++) {
                if (names[i].equalsIgnoreCase(targetName)) {
                    System.out.println("Contact Found at Index: " + i);
                    System.out.println("-------------------");
                    isFound = true;
                    break;
                }
            }

            if (isFound == false) {
                System.out.println("Contact Not Found");
                System.out.println("-------------------");
            }

            System.out.print("Search Again? [1] Yes / [2] No: ");
            int response = scan.nextInt();
            scan.nextLine();
            System.out.println("-------------------");


            if (response  == 2){
                System.out.println("Try Again Sometime!");
                break;
            }
        }
        scan.close();
    }
}
