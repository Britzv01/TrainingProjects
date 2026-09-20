public class ObjectStudentTest {
    public static void main (String [] args){
        Student student1 = new Student("Onycah", 20, 3.75);
        Student student2 = new Student("Danzhel", 20, 3.5);

        //System.out.println(student1.name + student1.age + student1.gpa + student1.isEnrolled);
        //System.out.println(student2.name + student2.age + student2.gpa + student2.isEnrolled);

        student1.study();
        student2.study();
    }
}
