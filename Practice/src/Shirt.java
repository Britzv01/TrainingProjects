public class Shirt {
    String design;
    String color;
    double price;

    Shirt(String design, String color, double price){
        this.design = design;
        this.color = color;
        this.price = price;
    }
    static void main() {
        Shirt shirt1 = new Shirt("Stripes", "Red", 99.50);

        System.out.println(shirt1.price);
    }
}
