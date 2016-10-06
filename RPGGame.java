import java.util.*;
/**
 * Created by Jan on 05.10.2016.
 */

public class RPGGame {
    public static String Playername;
    public static double Playerhealth = 100;
    public static double EnemyHealth = 100;
    public static int Level = 0;
    public static int PlayMaxDamage = 5;
    public static int EnemyMaxDamage = 2;
    public static int Money = 50;

    public static void main(String[] Args) {
        Scanner Reader = new Scanner(System.in);

        System.out.println("What is your name?");
        Playername = Reader.nextLine();
        System.out.println("Hello " + Playername + "!");

        while (true) {
            System.out.println("Your health is " + Playerhealth + ". And you have " + Money + "$. You maximum damage is " + PlayMaxDamage);
            System.out.println("[1]Buy more health: 10$");
            System.out.println("[2]Better sword: 50$");
            System.out.println("[3]Fight next round");
            System.out.println("[4]End game");


            String PA = Reader.nextLine();
            if (PA.equals("1")) {
                if (Money >= 10) {
                    Playerhealth = Playerhealth + 10;
                    Money = Money - 10;
                } else {
                    System.out.println("You dont have enough money!");
                }
            } else if (PA.equals("2")) {
                if (Money >= 50) {
                    PlayMaxDamage = PlayMaxDamage + 5;
                    Money = Money - 50;
                } else {
                    System.out.println("You dont have enough money!");
                }
            } else if (PA.equals("4")) {
                System.out.println("Good bye!");
                break;
            } else if (PA.equals("3")) {
                Level = Level +1;
                EnemyHealth = Level*10;
                while (Playerhealth > 0 & EnemyHealth > 0) {
                    double PD = Math.random() * PlayMaxDamage;
                    double ED = Math.random() * EnemyMaxDamage;

                    Playerhealth = Playerhealth - ED;
                    EnemyHealth = EnemyHealth - PD;
                }
                if (Playerhealth <= 0 & EnemyHealth <= 0) {
                    System.out.println("Its a draw");
                    break;
                }
                if (Playerhealth <= 0) {
                    System.out.println("You have lost!");
                    break;
                } else if (EnemyHealth <= 0) {
                    {
                        System.out.println("You have won!");
                        Money = Money + (Level*4);
                    }
                }

            }
        }
    }
}
