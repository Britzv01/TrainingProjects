import java.util.Scanner;

public class CurrencyConverter {
    static void dollarToEuro(double dollar){
        double convertedValue = dollar * 0.86;
        System.out.printf("Converted to Euro Value: €%,.2f%n", convertedValue);
    }

    static void dollarToPound(double dollar){
        double convertedValue = dollar * 0.74;
        System.out.printf("Converted to British Pound Value: £%,.2f%n", convertedValue);
    }

    static void dollarToYen(double dollar){
        double convertedValue = dollar * 153.62;
        System.out.printf("Converted to Japanese Yen Value: ¥%,.2f%n", convertedValue);
    }

    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        double dollar;
        char currencyChoice, choice;
        boolean isRunning = true;

        //Greeting
        System.out.println("Dollar Converter");
        System.out.println("--------------------");

        while(isRunning) {
            //Ask for choice
            System.out.print("""
                    1. Convert
                    2. Exit
                    """);
            System.out.print(": ");
            choice = scan.next().charAt(0);

            System.out.println("--------------------");
            if (choice == '1') {
                //Ask for what value to convert it to
                System.out.print("""
                        Select conversion value
                        1. Euro (€)
                        2. British Pound (£)
                        3. Japanese Yen (¥)
                        """);
                System.out.print(": ");
                currencyChoice = scan.next().charAt(0);
                System.out.println("--------------------");

                if ((currencyChoice == '1') || (currencyChoice == '2') || (currencyChoice == '3')){
                    //Ask for money to convert
                    System.out.print("Enter amount to convert: ");
                    dollar = scan.nextDouble();
                    System.out.println("--------------------");

                    //a switch case depending on choice
                    if (dollar < 0) {
                        System.out.println("Dollar can't be negative");
                    } else {
                        switch (currencyChoice) {
                            case '1' -> dollarToEuro(dollar);
                            case '2' -> dollarToPound(dollar);
                            case '3' -> dollarToYen(dollar);
                        }
                    }
                    System.out.println("--------------------");
                }

                else {
                    System.out.println("Invalid Choice!");
                    System.out.println("--------------------");

                }
            }

            else if (choice == '2') {
                System.out.println("Thank you!");
                break;
            }

            else {
                System.out.println("Choice Invalid!");
            }
        }

        scan.close();
    }
}

