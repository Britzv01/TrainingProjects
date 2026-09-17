import java.util.Scanner;

public class VarArgs {
    void average (double... numbers){
        double sum = 0;
        for (double number : numbers){
            sum += number;
        }

        System.out.println("Average: " + (sum / numbers.length));
    }
    public static void main (String [] args){
        Scanner scan = new Scanner (System.in);
        VarArgs obj = new VarArgs();

        obj.average(2, 4, 6, 8, 9.2);
    }
}
