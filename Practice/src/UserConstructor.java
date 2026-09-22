public class UserConstructor {
    String username;
    String email;
    int age;

    UserConstructor(){
        this.username = "Anonymous";
        this.email = "Not Provided";
        this.age = 0;
    }
    UserConstructor(String username){
        this.username = username;
        this.email = "Not Provided";
        this.age = 0;
    }
    UserConstructor(String username, String email){
        this.username = username;
        this.email = email;
        this.age = 0;
    }

    UserConstructor(String username, String email, int age){
        this.username = username;
        this.email = email;
        this.age = age;
    }

}
