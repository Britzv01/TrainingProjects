public class CarClass {
    String brand = "Honda";
    String model = "Click";
    int year = 2006;
    double price = 58000.60;
    boolean isRunning = false;

    void start(){
        isRunning = true;
        System.out.println("You started the engine");
    }

    void stop(){
        isRunning = false;
        System.out.println("You stopped the engine");
    }

    void drive(){
        System.out.println("You're driving the " + model);
    }

    void brake(){
        System.out.println("You brake the " + model );
    }
}
