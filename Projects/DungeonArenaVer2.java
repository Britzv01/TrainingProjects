import java.util.Scanner;

public class DungeonArenaVer2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Monsters [] enemy = {new Monsters("Goblin", 150, 20), new Monsters("Skeleton", 100, 10), new Monsters("Troll", 200, 50)};

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

            for (int i = 0; i < enemy.length; i++){
                System.out.printf("A Wild %s Encountered!%n", enemy[i].type);
                System.out.printf("Enemy Health: %d%n", enemy[i].health);
                while (character.health > 0 && enemy[i].health > 0) {
                    System.out.println("----------------");
                    System.out.printf("""
                            Attack the Enemy
                            [1] - %s | %d
                            [2] - %s | %d%n""", character.attackName1, character.attack1Power, character.attackName2, character.attack2Power);
                    System.out.print(": ");
                    int move = scan.nextInt();

                    if ((move != 1) && (move != 2)){
                        System.out.println("Invalid Attack!");
                        continue;
                    }
                    System.out.println("----------------");

                    switch (move) {
                        case 1 -> {
                            System.out.println("You used " + character.attackName1);
                            character.attack(move, enemy[i]);
                            System.out.println("You dealt " + (int) character.attackDamage);
                        }
                        case 2 -> {
                            System.out.println("You used " + character.attackName2);
                            character.attack(move, enemy[i]);
                            System.out.println("You dealt " + (int) character.attackDamage);
                        }
                    }

                    if (enemy[i].health > 0) {
                        System.out.println("Enemy Health: " + enemy[i].health);
                        System.out.println("----------------");

                        System.out.println("Enemy used " + enemy[i].attack1Name);
                        enemy[i].attack1(character);
                        System.out.println("Enemy dealt " + (int) enemy[i].enemyAttackDamage);

                        if (character.health <= 0) {
                            System.out.println("Health: " + 0);
                            break;
                        }

                        System.out.println("Health: " + character.health);
                    }

                    else {
                        System.out.println("----------------");
                        System.out.println("You successfully defeated the enemy " + enemy[i].type);
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
    double attackPower = 25;
    static int activeMonsters = 0;
    boolean isDefeated;
    String attack1Name;
    int attack1Power;
    double enemyAttackDamage;

    Monsters(String type, int health, int defense) {
        this.type = type;
        this.health = health;
        this.defense = defense;
        this.isDefeated = false;
        this.attack1Name = "Stab";
        this.attack1Power = 25;

        activeMonsters++;
    }

    void attack1(Characters hero){
        enemyAttackDamage = attack1Power * (attackPower / hero.defense);
        hero.health -= (int) enemyAttackDamage;
    }
}




