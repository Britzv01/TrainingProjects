import java.util.Scanner;

public class SmartHomeDashboard {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int deviceNum;

        System.out.println("Smart Home Dashboard");
        System.out.println("--------------------");

        System.out.print("Enter number of devices: ");
        deviceNum = scan.nextInt();
        scan.nextLine();

        SmartDevice [] devices = new SmartDevice[deviceNum];

        for(int i = 0; i < devices.length; i++){
            System.out.println("------------------------");
            System.out.printf("Enter Device #%d Name: ", (i + 1));
            String deviceName = scan.nextLine();

            System.out.println("------------------------");
            System.out.printf("Enter Device #%d Wattage: ", (i + 1));
            double powerDraw = scan.nextDouble();
            scan.nextLine();

            devices[i] = new SmartDevice(deviceName, powerDraw);
        }

        PowerHub powerHub = new PowerHub();

        for (SmartDevice device : devices){
            powerHub.plugIn(device);
        }

        System.out.println("------------------------");
        SmartDevice.displayTotalPower();

        for (int k = 0; k < devices.length; k++){
            System.out.println("------------------------");
            System.out.printf("""
                    Device #%d Overview
                    Name: %s
                    Wattage: %.2f
                    """, (k + 1), devices[k].deviceName, devices[k].powerDraw);
        }
    }
}

class SmartDevice {
    String deviceName;
    double powerDraw;
    static double totalNetworkPower = 0;

    SmartDevice(String deviceName, double powerDraw){
        this.deviceName = deviceName;
        this.powerDraw = powerDraw;
    }

    void turnOn(){
        totalNetworkPower += this.powerDraw;
    }

    void turnOff(){
        totalNetworkPower -= this.powerDraw;
    }

    static void displayTotalPower(){
        System.out.printf("Total Network Power: %.2f", totalNetworkPower);
    }
}

class PowerHub {
    void plugIn(SmartDevice device){
        device.turnOn();
    }
}
