import java.util.Random;
import java.util.Scanner;

public class DungeonArenaVer2 {
    Scanner scan = new Scanner(System.in);
    Monsters [] enemy = new Monsters[5];
    int enemyType;

    DungeonArenaVer2(){
        for (int i = 0; i < enemy.length; i++){
            enemy[i] = new Monsters(i);
        }
    }

    Characters characterSelect(){
        System.out.print("Enter name: ");
        String name = scan.nextLine();

        while(true){
            System.out.println("----------------");
            System.out.println("""
                    Select a Role:
                    · Warrior
                    · Mage
                    · Vanguard""");
            System.out.print(": ");
            String role = scan.nextLine().toLowerCase();
            System.out.println("----------------");

            if ((!role.equals("warrior")) && (!role.equals("mage")) && !role.equals("vanguard")) {
                System.out.println("Invalid Role!");
                System.out.println("----------------");
                continue;
            }

            Characters character = new Characters(name, role);
            character.displayStats();
            System.out.println("----------------");
            return character;
        }
    }

    int enemySelect() {
        while(true) {
            System.out.println("Select an Enemy");
            for (int i = 0; i < enemy.length; i++) {
                System.out.printf("[%d] - %-8s | %s%n", (i + 1), enemy[i].type, (!enemy[i].isDefeated) ? "Available" : "Defeated");
            }
            System.out.print(": ");
            enemyType = scan.nextInt() - 1;

            if (enemy[enemyType].isDefeated) {
                System.out.println("------------------");
                System.out.println("Enemy is Defeated! Choose Again!");
                System.out.println("------------------");
                continue;
            }

            break;
        }

        System.out.println("----------------");
        System.out.printf("You encountered a %s!%n", enemy[enemyType].type);
        System.out.printf("Enemy Health: %d%n", enemy[enemyType].health);

        return enemyType;
    }

    void gameSequence(Characters character, int enemyType) {
        while (character.health > 0 && enemy[enemyType].health > 0) {
            System.out.println("----------------");
            System.out.printf("""
                            Attack the Enemy
                            [1] - %-8s | %d 
                            %s
                            [2] - %-8s | %d 
                            %s%n""", character.attackName1, character.attack1Power, character.attack1Description, character.attackName2, character.attack2Power, character.attack2Description);
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
                    character.attack(character, move, enemy[enemyType]);
                    System.out.println("You dealt " + (int) character.attackDamage);
                }
                case 2 -> {
                    System.out.println("You used " + character.attackName2);
                    character.attack(character, move, enemy[enemyType]);
                    System.out.println("You dealt " + (int) character.attackDamage);
                }
            }

            if (enemy[enemyType].health > 0) {
                System.out.println("Enemy Health: " + enemy[enemyType].health);
                System.out.println("----------------");

                System.out.println("Enemy used " + enemy[enemyType].attack1Name);
                enemy[enemyType].attack(character);
                System.out.println("Enemy dealt " + (int) enemy[enemyType].enemyAttackDamage);

                if (character.health <= 0) {
                    System.out.println("Health: " + 0);
                    break;
                }

                System.out.println("Your Health: " + character.health);
            }

            else {
                System.out.println("----------------");
                System.out.println("You successfully defeated the enemy " + enemy[enemyType].type);
                enemy[enemyType].isDefeated = true;
                Monsters.activeMonsters--;
                System.out.println("----------------");
            }
        }
    }

    public static void main(String[] args) {
        DungeonArenaVer2 game = new DungeonArenaVer2();

        System.out.println("Dungeon Arena V2");
        System.out.println("----------------");

        Characters character = game.characterSelect();

        while(Monsters.activeMonsters > 0) {
            int enemyChoice = game.enemySelect();
            game.gameSequence(character, enemyChoice);

            if (character.health <= 0) {
                System.out.println("----------------");
                System.out.println("Defeated! Try Again!");
                System.out.println("----------------");
                break;
            }
        }
        game.scan.close();
    }
}

class Characters {
    String name;
    String role;
    int health;
    double attackPower;
    int defense;
    double attackDamage;
    int attack1Power;
    int attack2Power;
    String attackName1;
    String attackName2;
    String attack1Description;
    String attack2Description;

    Characters(String name, String role){
        this.name = name;

        if (role.equals("warrior")) {
            this.role = "Warrior";
            this.health = 130;
            this.attackPower = 25;
            this.defense = 20;

            this.attackName1 = "Heavy Slash";
            this.attack1Power = 30;
            this.attack1Description = "Slashes the Enemy Heavily";

            this.attackName2 = "War Cry";
            this.attack2Power = 10;
            this.attack2Description = "Screams and Increases Attack by 5";
        }

        else if (role.equalsIgnoreCase("mage")){
            this.role = "Mage";
            this.health = 80;
            this.attackPower = 40;
            this.defense = 10;

            this.attackName1 = "Ember";
            this.attack1Power = 25;
            this.attack1Description = "Expels a Fire Spell and Burns the Enemy";

            this.attackName2 = "Frostbite";
            this.attack2Power = 40;
            this.attack2Description = "Conjures a Blizzard and 30% chance to Freeze Opponent";
        }

        else if (role.equalsIgnoreCase("vanguard")) {
            this.role = "Vanguard";
            this.health = 170;
            this.attackPower = 15;
            this.defense = 35;

            this.attackName1 = "Shield Bash";
            this.attack1Power = 20;
            this.attack1Description = "Slams the Enemy using a Shield";

            this.attackName2 = "Fortify";
            this.attack2Power = 5;
            this.attack2Description = "Releases a Shockwave and Heals Health and Increases Defense by 5";
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

    void attack(Characters character, int move, Monsters monster){
        if (character.role.equalsIgnoreCase("warrior")) {
            if (move == 1) {
                attackDamage = attack1Power * (attackPower / monster.defense);
                monster.health -= (int) attackDamage;
            }

            else if (move == 2) {
                attackDamage = attack2Power * (attackPower / monster.defense);
                monster.health -= (int) attackDamage;
                attackPower += 5;
            }
        }

        if (character.role.equalsIgnoreCase("mage")) {
            if (move == 1) {
                attackDamage = attack1Power * (attackPower / monster.defense);
                monster.health -= (int) attackDamage;
            }

            else if (move == 2) {
                attackDamage = attack2Power * (attackPower / monster.defense);
                monster.health -= (int) attackDamage;
                double freezeChance = 0.3;

                if (Math.random() <= freezeChance){

                }
            }
        }

        if (character.role.equalsIgnoreCase("vanguard")) {
            if (move == 1) {
                attackDamage = attack1Power * (attackPower / monster.defense);
                monster.health -= (int) attackDamage;
            }

            else if (move == 2) {
                attackDamage = attack2Power * (attackPower / monster.defense);
                monster.health -= (int) attackDamage;
                health += 25;
            }
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