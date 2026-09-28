import java.util.Scanner;

public class DungeonArena {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        Hero character = new Hero("Mirio", 130, 50);
        Monster [] enemy = {new Monster("Goblin", 151), new Monster("Skeleton", 100), new Monster("Troll", 200)};

        while(Monster.activeMonsters > 0){
            System.out.println("Select an Enemy");
            for (int i = 0; i < enemy.length; i++){
                System.out.printf("[%d] - %s (%s)%n", (i + 1), enemy[i].type, ((!enemy[i].isDefeated) ? "Not Defeated" : "Defeated"));
            }
            System.out.print(": ");
            int chosenEnemy = scan.nextInt() - 1;

            if(enemy[chosenEnemy].isDefeated){
                System.out.println("------------------");
                System.out.println("Enemy is Defeated! Choose Again!");
                System.out.println("------------------");
                continue;
            }

            character.attack(enemy[chosenEnemy]);

        }
        scan.close();
    }
}

class Hero {
    String name;
    int health;
    int attackPower;

    Hero(String name, int health, int attackPower){
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    void attack(Monster monster){
        System.out.println("Enemy Health: " + monster.health);

        while (monster.health > 0) {
            System.out.println("------------------");
            monster.health -= attackPower;
            System.out.println("Enemy Health: " + monster.health);

            if (monster.health <= 0){
                System.out.println("------------------");

                System.out.println("You Defeated a " + monster.type);
                Monster.activeMonsters--;
                monster.isDefeated = true;
                break;
            }
        }

        System.out.println("------------------");
    }
}

class Monster {
    String type;
    int health;
    static int activeMonsters = 0;
    boolean isDefeated;

    Monster(String type, int health) {
        this.type = type;
        this.health = health;
        this.isDefeated = false;

        activeMonsters++;
    }
}
