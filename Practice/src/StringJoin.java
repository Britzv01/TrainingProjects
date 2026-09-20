public class StringJoin {
        public static void main() {
                // Joining Strings
                System.out.println(String.join("-", "2026", "04", "22"));

                // Joining Arrays
                String[] items = {"Eggs", "Milk", "Cheese"};
                System.out.println("The recipe for an omelette: " + String.join(", ", items));
        }
}


