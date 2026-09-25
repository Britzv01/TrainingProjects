public class EmployeeIDGenerator {
    public static void main(String [] args) {
        Employee employee1 = new Employee("Danzhel", "CS");
        Employee employee2 = new Employee("Onycah", "AT");
        Employee employee3 = new Employee("Danycah", "IT");

        Employee [] arr = {employee1, employee2, employee3};

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i].name);
            System.out.println(arr[i].employeeID);
            System.out.println(arr[i].departmentID);
            System.out.println("-----------------");
        }
        System.out.println(Employee.totalEmployees);
    }
}

class Employee {
    String name;
    String employeeID;
    String departmentID;
    static int totalEmployees = 0;

    Employee(String name, String departmentID){
        this.name = name;
        this.departmentID = departmentID;
        totalEmployees++;

        this.employeeID = String.format("%s-%03d", this.departmentID, totalEmployees);
    }

}
