import java.util.*;

public class Main {
    static int maxHP = 150;
    static int playerHP = 100;
    static int SnekHP;
    static int PearManHP;
    static int MichaelOBossHP;

    static Scanner input = new Scanner(System.in);
    private static boolean finalBoss = false;

    public static void main(String[] args) {

        Boolean finalBoss = false;

        //Initializing types as a String Array
        String[] types = {"Michael", "Fire", "Water"};

        System.out.println("Hello! Welcome to the accurate 'In The Bag' battle simulator");
        System.out.println("You will be fighting a gauntlet of bosses with differing types");
        System.out.println("Before we get started which out of the types Grass, Fire, and Water would you like to have?");
        String type = input.nextLine();
        if (type.equals("MichaelD")) {
            System.out.println("SECRET BOSS");
            secretBoss();
        } else {
            while (!(type.equals("Grass") || type.equals("Fire") || type.equals("Water") || type.equals("MichaelD"))) {
                System.out.println("That is not an option, please select a valid type." + "\n");
                type = input.nextLine();
            }
        }
        startGame();
    }
    public static void startGame() {
        //Initializing a HashMap that stores bosses
        HashMap<Integer, String> bosses = new HashMap<Integer, String>();

        //Bosses
        //Initializing Snek in HashMap
        //Initializing SnekHP
        SnekHP = 50;
        bosses.put(1, "    //////\n" +
                "   /     /  \n" +
                "   |\\ / /   \\\n" +
                "    \\  /    |\\ \n" +
                "     | |   / /\n" +
                "     \\ \\__/ /\n" +
                "      \\____/ ");
        //Snek is a fire type

        //Initializing PearMan in HashMap
        //Initializing PearManHP
        PearManHP = 100;
        bosses.put(2, "     /\n" +
                "   /  \\\n" +
                "  /    \\\n" +
                " /      \\\n" +
                "| _   _  |\n" +
                "|        |\n" +
                " \\  _   /\n" +
                "  ------");
        //PearMan is a Water type

        //Initializing MichaelOBoss in HashMap
        //Initializing MichaelOBossHP
        MichaelOBossHP = 200;
        bosses.put(3, "  , ,,, ,,\n" +
                "///////   \\\n" +
                "| ^    ^   |\n" +
                "| @    @   |\n" +
                "|   <      |\n" +
                " \\ ~~~~~  / \n" +
                "  ========");
        //MichaelOBoss is the final boss and is also a Michael type

        int MichaelDHP = 300;
        bosses.put(4, "");
        //End Boss Creation

        System.out.println("Which boss would you like to face first?");
        System.out.println("Easy: Snek the Fire snake");
        System.out.println("Medium: PareMan the Water pear");


        if (finalBoss == true) {
            System.out.println("Impossible: MichaelO the Michael type");
        } else {
            System.out.println("Locked: \uD83D\uDD12");
        }


        // Selection for the first boss
        String boss = input.nextLine();
        while (!(boss.equals("Snek") || boss.equals("PareMan") || boss.equals("Easy") || boss.equals("Medium"))) {
            System.out.println("Please select a boss." + "\n");
            boss = input.nextLine();
        }
        if (boss.equals("Snek") || boss.equals("Easy")) {
            System.out.println(bosses.get(1));
            System.out.println("The Snek boss has appeared!\n");
            snekBoss();
        }
        if (boss.equals("PareMan") || boss.equals("Medium")) {
            System.out.println(bosses.get(2));
            pareBoss();
        }
    }

    //System.out.println(bosses.get(1));
    //System.out.println(bosses.get(2));
    //System.out.println(bosses.get(3));


    // initializes the random values for the damage calculations
    static int damPerRound = (int) (Math.random() * 10);
    static int critCalc = (int) (Math.random() * 16);
// calculates how much damage will be done to the enemy
    public static void playerDamage() {
        damPerRound = (int) (Math.random() * 10 + 1);
        critCalc = (int) (Math.random() * 16 + 1);
        // checks for crit hit
        if (critCalc == 16) {
            System.out.println("Critical hit!");
            damPerRound = damPerRound * 2 + 5;
        }
        System.out.println("You did " + damPerRound + " damage!");
    }

    static int healPerRound = (int) (Math.random() * 25 + 1);
// used for healing the player from 5 hp healed to 30 hp healed
    public static void playerHeal() {
        damPerRound = 0;
        healPerRound = (int) (Math.random() * 30 + 5);

        System.out.println("You healed " + healPerRound + "!");
        playerHP += healPerRound;
        // making sure you don't heal over 150 hp
        playerHP = Math.min(maxHP, playerHP);
    }

    //static int chanceToRun = (int)  (Math.random())
    static int damPerRoundSnek = (int) (Math.random() * 10);
    static int critCalcSnek = (int) (Math.random() * 16);
// this is the damage calculations for how much the snek will do
    public static void snekAttack() {
        damPerRoundSnek = (int) (Math.random() * 10);
        critCalcSnek = (int) (Math.random() * 16);
        if (critCalcSnek == 16) {
            System.out.println("Critical hit!");
            damPerRoundSnek = damPerRoundSnek * 2 + 5;
        }
        System.out.println("The enemy does " + damPerRoundSnek + " damage!");
        // updating both the players attack and the sneks attack
        SnekHP -= damPerRound;
        playerHP -= damPerRoundSnek;
    }
    static int damPerRoundPare = (int) (Math.random() * 20);
    static int critCalcPare = (int) (Math.random() * 16);
    // this method essentially works the same as the snek attack method but for the pear
    // the pear has more power so i needed a spepret method
    public static void pareAttack() {
        damPerRoundPare = (int) (Math.random() * 25);
        critCalcPare = (int) (Math.random() * 16);
        if (critCalcPare == 16) {
            System.out.println("Critical hit!");
            damPerRoundPare = damPerRoundPare * 2 + 5;
        }
        System.out.println("The enemy does " + damPerRoundPare + " damage!");
        PearManHP -= damPerRound;
        playerHP -= damPerRoundPare;
    }
// This is the main method for the snek boss and calss the snek attack method and player attack method
    public static void snekBoss() {
        while (SnekHP > 0 && playerHP > 0) {
            System.out.println("HP: " + playerHP);
            System.out.println("1.) Attack");
            System.out.println("2.) Heal");
            System.out.println("Boss HP: " + SnekHP);
            int attHeaRun = input.nextInt();

            switch (attHeaRun) {
                case 1:
                    playerDamage();
                    break;
                case 2:
                    playerHeal();
                    break;
            }
            snekAttack();
            if (SnekHP <= 0) {
                System.out.println("You won!");
                System.out.println("Continue?  y/n");
                String cont = input.next();
                while(!(cont.equals("y")) && (!(cont.equals("n")))){
                    System.out.println("Please Select a correct opperator");
                    System.out.println("Continue?  y/n");
                    cont = input.next();
                }
                switch (cont) {
                    case "y":
                        playerHP = 100;
                        SnekHP = 50;
                        startGame();
                        cont = input.next();
                    case "n":
                        System.exit(0);
                }

            } else if (playerHP <= 0) {
                System.out.println("You lost..");
            }

        }
    }

    // This is the main method for the pare boss and class the pare attack method and player attack method
    public static void pareBoss() {
            while (PearManHP > 0 && playerHP > 0) {
                System.out.println("HP: " + playerHP);
                System.out.println("1.) Attack");
                System.out.println("2.) Heal");
                System.out.println("Boss HP: " + PearManHP);
                int attHeaRun = input.nextInt();

                switch (attHeaRun) {
                    case 1:
                        playerDamage();
                        break;
                    case 2:
                        playerHeal();
                        break;
                }
                pareAttack();
                if (PearManHP <= 0){
                    System.out.println("You won!");
                    System.out.println("Continue?  y/n");
                    System.out.println();
                    String cont = input.nextLine();
                    finalBoss = true;

                    while(!(cont.equals("y")) && (!(cont.equals("n")))){
                        System.out.println("Please Select a correct opperator");
//                        System.out.println("Continue?  y/n");
                        cont = input.next();
                    }
                    if(cont.equals("y")){
                        playerHP = 100;
                        PearManHP = 100;
                        startGame();
                        finalBoss = true;
                    }
                    else if(cont.equals("n")){
                        System.exit(0);
                    }

                } else if (playerHP <= 0) {
                    System.out.println("You lost..");
                }
            }
        }
        //not in use
    public static void secretBoss() {
        System.exit(0);
    }
}