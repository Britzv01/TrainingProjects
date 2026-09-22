public class CarClass {
    String model;
    String color;
    String [] parts;

    CarClass(String model, String color){
        this.model = model;
        this.color = color;
    }

    CarClass(String... parts){
        this.parts = parts;
    }

    void drive(){
        System.out.printf("You drive the %s %s", color, model);
    }

    void showParts(){
        for(int i = 0; i < parts.length; i++){
            System.out.println(parts[i]);
        }
    }

    static void main() {
       /* CarClass car1 = new CarClass("Honda", "Black");
        CarClass car2 = new CarClass("Mitsubishi", "White");
        CarClass car3 = new CarClass("Ferrari", "Red");
        CarClass car4 = new CarClass("Window", "Windshield", "Handle", "Brake");

        CarClass[] cars = {car1, car2, car3, car4};
       */

        CarClass[] cars = {new CarClass("Honda,", "Black"), new CarClass("Mustang", "Blue")};

        for (int i = 0; i < cars.length; i++){
            cars[i].drive();
            System.out.println("");
        }

        for (CarClass carits : cars){
            carits.drive();
            System.out.println("");
        }
    }

}
