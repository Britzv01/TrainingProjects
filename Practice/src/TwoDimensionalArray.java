public class TwoDimensionalArray {
    public static void main (String [] args){
        String [] vegetables = {"Cabbage", "Eggplant", "Chayote"};
        String [] fruits = {"Banana", "Apple", "Grapes"};
        String [] meats = {"Pork", "Beef", "Chicken", "Fish"};
        String [][] groceries = {fruits, vegetables, meats};

        /* ENHANCED FOR LOOP for 2D Array
        for (String [] foods : groceries){
            for (String food : foods){
                System.out.println(food);
            }
       */

        /* STANDARD FOR LOOP for 2D Array
        groceries[0][2] = "Raspberry";
        for (int i = 0; i < groceries.length; i++){
            for(int j = 0; j < groceries[i].length; j++){
                System.out.print(groceries[i][j] + " ");
            }
            System.out.println("");
        }
        */

        //Phone Number Pad as a 2D Array
        char [][] numPad = {{'1', '2', '3'},
                            {'4', '5', '6'},
                            {'7', '8', '9'},
                            {'*', '0', '#'}};

        for (char [] numbers : numPad){
            for (char number : numbers){
                System.out.print(number + " ");
            }
            System.out.println("");
        }
    }
}
