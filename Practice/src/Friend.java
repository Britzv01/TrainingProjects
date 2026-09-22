public class Friend {
    String name;
    static int numFriends;

    Friend(String name){
        this.name = name;
        numFriends++;
    }

    static void showFriends(){
        System.out.println("You have " + numFriends);
    }

    public static void main (String [] args){
        Friend friend1 = new Friend("Onycah");
        Friend friend2 = new Friend("Dan");
        Friend friend3 = new Friend("Danycah");
        Friend friend4 = new Friend("Onyczhel");

        System.out.println(Friend.numFriends);
        friend1.showFriends();

    }
}
