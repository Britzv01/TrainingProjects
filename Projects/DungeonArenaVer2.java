import java.util.Random;
import java.util.Scanner;

public class DungeonArenaVer2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        String [] enemyNames = {"Slime", "Goblin", "Skeleton", "Witch", "Troll"};

        System.out.println("Dungeon Arena V2");
        System.out.println("----------------");

        System.out.print("Enter name: ");
        String name = scan.nextLine();
        System.out.println("----------------");

        while (true) {
            System.out.println("""
                    Select a Role:
                    · Warrior
                    · Mage
                    · Vanguard""");
            System.out.print(": ");
            String role = scan.nextLine().toLowerCase();
            System.out.println("----------------");

            if ((!role.equals("warrior")) && (!role.equals("mage")) && !role.equals("vanguard")){
                System.out.println("Invalid Role!");
                System.out.println("----------------");
                continue;
            }

            Characters character = new Characters(name, role);
            character.displayStats();
            System.out.println("----------------");

            while(Monsters.activeMonsters > 0) {
                System.out.println("Select an Enemy");
                for (int i = 0; i < enemyNames.length; i++) {
                    System.out.printf("[%d] - %s%n", (i + 1), enemyNames[i]);
                }
                System.out.print(": ");
                int enemyType = scan.nextInt() - 1;
                Monsters enemy = new Monsters(enemyType);

                if (enemy.isDefeated) {
                    System.out.println("------------------");
                    System.out.println("Enemy is Defeated! Choose Again!");
                    System.out.println("------------------");
                    continue;
                }

                System.out.printf("A Wild %s Encountered!%n", enemy.type);
                System.out.printf("Enemy Health: %d%n", enemy.health);

                while (character.health > 0 && enemy.health > 0) {
                    System.out.println("----------------");
                    System.out.printf("""
                            Attack the Enemy
                            [1] - %s | %d
                            [2] - %s | %d%n""", character.attackName1, character.attack1Power, character.attackName2, character.attack2Power);
                    System.out.print(": ");
                    int move = scan.nextInt();

                    if ((move != 1) && (move != 2)) {
                        System.out.println("Invalid Attack!");
                        continue;
                    }
                    System.out.println("----------------");

                    switch (move) {
                        case 1 -> {
                            System.out.println("You used " + character.attackName1);
                            character.attack(move, enemy);
                            System.out.println("You dealt " + (int) character.attackDamage);
                        }
                        case 2 -> {
                            System.out.println("You used " + character.attackName2);
                            character.attack(move, enemy);
                            System.out.println("You dealt " + (int) character.attackDamage);
                        }
                    }

                    if (enemy.health > 0) {
                        System.out.println("Enemy Health: " + enemy.health);
                        System.out.println("----------------");

                        System.out.println("Enemy used " + enemy.attack1Name);
                        enemy.attack(character);
                        System.out.println("Enemy dealt " + (int) enemy.enemyAttackDamage);

                        if (character.health <= 0) {
                            System.out.println("Health: " + 0);
                            break;
                        }

                        System.out.println("Health: " + character.health);
                    }

                    else {
                        System.out.println("----------------");
                        System.out.println("You successfully defeated the enemy " + enemy.type);

                        System.out.println("----------------");
                    }

                    if (character.health <= 0) {
                        System.out.println("----------------");
                        System.out.println("Defeated! Try Again!");
                        System.out.println("----------------");
                        break;
                    }
                }
            }
            break;
        }
        scan.close();
    }
}

class Characters {
    String name;
    String role;
    int health;
    double attackPower;
    int defense;
    int attack1Power;
    int attack2Power;
    double attackDamage;
    String attackName1;
    String attackName2;

    Characters(String name, String role){
        this.name = name;

        if (role.equals("warrior")) {
            this.role = "Warrior";
            this.health = 120;
            this.attackPower = 25;
            this.defense = 15;

            this.attackName1 = "Guillotine";
            this.attack1Power = 20;
            this.attackName2 = "Heavy Slash";
            this.attack2Power = 45;

        }

        else if (role.equalsIgnoreCase("mage")){
            this.role = "Mage";
            this.health = 80;
            this.attackPower = 35;
            this.defense = 5;

            this.attackName1 = "Ember";
            this.attack1Power = 20;
            this.attackName2 = "Fire Ball";
            this.attack2Power = 55;
        }

        else if (role.equalsIgnoreCase("vanguard")) {
            this.role = "Vanguard";
            this.health = 160;
            this.attackPower = 15;
            this.defense = 25;

            this.attackName1 = "Concussive Slam";
            this.attack1Power = 15;
            this.attackName2 = "Shield Bash";
            this.attack2Power = 25;
        }
    }

    void displayStats () {
        System.out.printf("""
                Name: %s
                Role: %s
                Health: %d
                Attack Power: %d
                Defense: %d%n""", name, role, health, (int) attackPower, defense);
    }

    void attack(int move, Monsters monster){

        if (move == 1) {
            attackDamage = attack1Power * (attackPower / monster.defense);
            monster.health -= (int) attackDamage;
        }

        else if (move == 2) {
            attackDamage = attack2Power * (attackPower / monster.defense);
            monster.health -= (int) attackDamage;
        }
    }
}

class Monsters {
    String type;
    int health;
    double defense;
    double attackPower;
    static int activeMonsters = 0;
    boolean isDefeated;
    String attack1Name;
    int attack1Power;
    double enemyAttackDamage;

    Monsters(int enemyChoice) {
        if (enemyChoice == 0) {
            this.type = "Slime";
            this.health = 50;
            this.defense = 10;
            this.attackPower = 10;
            this.isDefeated = false;

            this.attack1Name = "Splash";
            this.attack1Power = 10;
        }

        if (enemyChoice == 1) {
            this.type = "Goblin";
            this.health = 100;
            this.defense = 20;
            this.attackPower = 15;
            this.isDefeated = false;

            this.attack1Name = "Stab";
            this.attack1Power = 25;
        }

        if (enemyChoice == 2) {
            this.type = "Skeleton";
            this.health = 70;
            this.defense = 10;
            this.attackPower = 30;
            this.isDefeated = false;

            this.attack1Name = "Piercing Shot";
            this.attack1Power = 35;
        }

        if (enemyChoice == 3) {
            this.type = "Witch";
            this.health = 100;
            this.defense = 40;
            this.attackPower = 40;
            this.isDefeated = false;

            this.attack1Name = "Burning Hex";
            this.attack1Power = 45;
        }

        if (enemyChoice ==  4) {
            this.type = "Troll";
            this.health = 150;
            this.defense = 30;
            this.attackPower = 50;
            this.isDefeated = false;

            this.attack1Name = "Stone Hammer";
            this.attack1Power = 60;
        }

        activeMonsters++;
    }

    void attack(Characters hero) {
        enemyAttackDamage = attack1Power * (attackPower / hero.defense);
        hero.health -= (int) enemyAttackDamage;
    }
}




