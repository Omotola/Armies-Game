import java.util.LinkedList;
/** Main class that handles battles.
 * @author Omotola Akeredolu
 */

public class Battle {

    /**
     * The function that handles rounds of fighting
     *
     * @param army1 The first army
     * @param army2 The second army
     */

    public static void Fight(Army army1, Army army2){
        System.out.println("=====BATTLE BEGINS=====\n");

        int counter = 1; //Round Counter

//      Loop through rounds until one of the armies is defeated
        while (!army1.isDefeated() && !army2.isDefeated()) {

//          Get next troop for each army
            Troop t1 = army1.GetNextTroop();
            Troop t2 = army2.GetNextTroop();
            System.out.println("Round "+counter+": Player1 "+ t1.GetTroopType()+"(health="+t1.GetHealth()+", TotalDamage="+t1.GetTotalDamage()
            +") vs Player2 "+ t2.GetTroopType()+"(health="+t2.GetHealth()+", TotalDamage="+t2.GetTotalDamage() +")");

//           Each Troop deals damage
            t1.DoDamage(t2);
            t2.DoDamage(t1);

//            Announce a troops death
            if(t1.isDead()){
                System.out.println("Player1 "+t1.GetTroopType()+" is Dead");
            }else if(t2.isDead()){
                System.out.println("Player2 "+t2.GetTroopType()+" is Dead");
            }
            counter++;
        }

//        Announce Winner
        System.out.println("\n=====FIGHT ENDED======\n");
        if(army1.isDefeated()){
            System.out.println("ARMY 2 is the winner. Remaining Troops:");
            army2.PrintTroopsWithHealth();
            System.out.println("\nThe most Outstanding Troop is:");
            army2.PrintOutstandingTroop();
        }else if(army2.isDefeated()){
            System.out.println("ARMY 1 is the winner. Remaining Troops:");
            army1.PrintTroopsWithHealth();
            System.out.println("The most Outstanding Troop is:");
            army1.PrintOutstandingTroop();
        }
    }


    /**
     * Main Function
     *
     * @param args
     */
    public static void main(String []args) {

//        Create First Army
        LinkedList<Army.TroopTypes> q1 = new LinkedList<Army.TroopTypes>();
        q1.add(Army.TroopTypes.MONKEY);
        q1.add(Army.TroopTypes.FLYINGMONKEY);
        q1.add(Army.TroopTypes.WIZARD);
        q1.add(Army.TroopTypes.BALLOON);

        Army army1 = new Army(q1);

//        Print Troops
        System.out.println("Army 1 Troops:");
        army1.PrintTroops();
        System.out.println("\n");

//        Create Second Army
        LinkedList<Army.TroopTypes> q2 = new LinkedList<Army.TroopTypes>();
        q2.add(Army.TroopTypes.FLYINGMONKEY);
        q2.add(Army.TroopTypes.WIZARD);
        q2.add(Army.TroopTypes.BALLOON);
        q2.add(Army.TroopTypes.MONKEY);

        Army army2 = new Army(q2);

//        Print Troops
        System.out.println("Army 2 Troops:");
        army2.PrintTroops();
        System.out.println("\n");


//        Start Fight
        Fight(army1,army2);
    }


}
