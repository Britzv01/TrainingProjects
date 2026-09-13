import java.util.Scanner;

public class GradeChecker {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        int [] grades = new int[5];

        System.out.println("Grade Tracker");
        System.out.println("------------------");
        while(true) {
            int totalSum = 0;
            int highestScore = 0;
            double gradeAverage;

            for (int i = 0; i < grades.length; i++) {
                System.out.print("Enter Grade #" + (i + 1) + ": ");
                grades[i] = scan.nextInt();

                totalSum += grades[i];

                if (grades[i] > highestScore) {
                    highestScore = grades[i];
                }
            }
            System.out.println("------------------");

            gradeAverage = (double) totalSum / grades.length;

            System.out.printf("Total Sum: %d%n", totalSum);
            System.out.printf("Average: %.2f%n", gradeAverage);
            System.out.printf("Highest Score: %d%n", highestScore);
            System.out.println("------------------");

            System.out.print("Track Grades Again? [1] Yes / [2] No: ");
            int replayChoice = scan.nextInt();
            System.out.println("------------------");

            if(replayChoice == 2){
                System.out.println("Thank You! Try Again!");
                break;
            }
        }
        scan.close();
    }
}
