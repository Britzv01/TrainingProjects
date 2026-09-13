import java.util.Scanner;
public class NameFormatter {

    static void formatName(String name){
        String [] splitName = name.trim().split(" ");
        String formattedFullName = "";

        for (int i = 0; i < splitName.length; i++){
            String firstLetter = splitName[i].substring(0, 1).toUpperCase();
            String restOfTheWord = splitName[i].substring(1).toLowerCase();

            formattedFullName += firstLetter + restOfTheWord + " ";
        }

        System.out.printf("""
                Full Name: %s
                Character Count: %d
                """, formattedFullName, formattedFullName.replace(" ", "").length());

        System.out.println("-------------------");
    }

    public static void main (String [] args) {
        Scanner scan = new Scanner(System.in);
        boolean isRunning = true;
        //header
        System.out.println("Name Formatter");
        System.out.println("-------------------");

        while (isRunning) {
            //initialize variables
            String name;
            int choice;
            boolean isPromptingToContinue = true;

            //ask for user input
            System.out.print("Enter your full name: ");
            name = scan.nextLine();
            System.out.println("-------------------");

            if(name.isEmpty()){
                System.out.println("You didn't enter anything! Try Again!");
                System.out.println("-------------------");
            }

            else {
                formatName(name);

                while(isPromptingToContinue){
                    System.out.print("Continue? (Yes [1] / No [2]): ");
                    choice = scan.nextInt();
                    scan.nextLine();
                    System.out.println("-------------------");

                    if (choice == 2){
                        System.out.println("Thank you!");
                        isRunning = false;
                        break;
                    }

                    else if (choice == 1){
                        break;
                    }

                    else {
                        System.out.println("Invalid Choice!");
                        System.out.println("-------------------");
                    }
                }
            }
        }
        scan.close();
    }
}

