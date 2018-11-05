import java.util.LinkedList;

/** Represents an Army.
 * @author Omotola Akeredolu
 */
public class Army {
    enum TroopTypes{BALLOON,WIZARD,FLYINGMONKEY,MONKEY;} //Enum for the Different types of troops
    int numberOfTroops = 20;//number of troops in an army
    int nextTroopCounter = 0;//Counter or index for the next troop to fight in a round
    Troop[] myTroops = new Troop[numberOfTroops]; //array of all troops


    /**
     * Constructor
     *
     * @param troopTypes List of the initial troop arrangement for the army
     *
     */
    public Army(LinkedList<TroopTypes> troopTypes){
        int troopCounter = 0;
        LinkedList<TroopTypes> tempQueue = (LinkedList<TroopTypes>)troopTypes.clone();

//      Loop through the arrangement queue, popping the last element in the list
//      and  use it to populate the army.
        while((troopCounter < numberOfTroops)){

            TroopTypes t = (TroopTypes)tempQueue.poll();
            myTroops[troopCounter] = CreateTroop(t);

//          If the arrangement list is empty, refresh it (Wrapping around the troops)
            if(tempQueue.isEmpty()){

                tempQueue = (LinkedList<TroopTypes>)troopTypes.clone();

            }
           troopCounter++;
        }
    }


    /**
     * The function creates and returns new troop objects
     *
     * @param t The Type of the Troop to be created
     * @return Returns new instance of the Troop
     */
    public Troop CreateTroop(TroopTypes t){
        switch (t){
            case MONKEY:
                return new Monkey();
            case FLYINGMONKEY:
                return new FlyingMonkey();
            case WIZARD:
                return new Wizard();
            case BALLOON:
                return new Balloon();
                default:
                    return null;
        }
    }


    /**
     * The function prints all troops that are not dead in our troop array(army)
     *
     */
    public void PrintTroops(){

        for (int i = 0; i<numberOfTroops; i++){

            if(!myTroops[i].isDead()) {

                System.out.println(myTroops[i].GetTroopType());
            }
        }
    }


    /**
     * The function prints all troops that are not dead in our troop array(army) together with
     * their health and total damage
     */
    public void PrintTroopsWithHealth(){
        for (int i = 0; i<numberOfTroops; i++){
            if(!myTroops[i].isDead()) {
                int binary = Integer.parseInt(Integer.toBinaryString(myTroops[i].GetTotalDamage()));
                System.out.println(myTroops[i].GetTroopType()+", health="+myTroops[i].GetHealth()+", Total Damage="+myTroops[i].GetTotalDamage()+", Binary="+ binary);
            }
        }
    }

    /**
     * The function retrieves the Next Troop to fight in a round
     * @return Returns a Troop object
     */
    public Troop GetNextTroop(){
        if (nextTroopCounter >= numberOfTroops){
            nextTroopCounter=0;
        }
        Troop nextTroop =myTroops[nextTroopCounter];
        nextTroopCounter++;

//        If the chosen troop is dead recurse
        if(nextTroop.isDead()){
            return GetNextTroop();
        }
        return nextTroop;
    }


    /**
     * The function checks if all troops in the army are dead
     * @return Returns a True if all troops are dead. Else returns false
     */

    public Boolean isDefeated(){
        for (int i = 0; i<numberOfTroops;i++){
            if(!myTroops[i].isDead()){
                return false;
            }
        }
        return true;
    }



    /**
     * The function prints the outstanding troop in army based on the maximum longest consecutive ones in the
     * binary representation of the troops' totalDamage amount.
     */

    public void PrintOutstandingTroop(){
        int outstandingCount = 0; //Stores max count of Consecutive ones of the total Damage amount
        Troop outstandingTroop = null; // Stores the most Outstanding Troop based on previous variable
        int outStandingBinary = 0; //Stores the binary representation of the outstanding troops total Damage amount

//      Loop through all troops that are still alive and get binary representation of the total damage amount
        for (int i = 0; i<numberOfTroops; i++){
            if(!myTroops[i].isDead()) {
                int binary = Integer.parseInt(Integer.toBinaryString(myTroops[i].GetTotalDamage()));
                char[] binaryArr= Integer.toBinaryString(myTroops[i].GetTotalDamage()).toCharArray();
                int max = 0;//stores max count of longest consecutive ones for a SINGLE troop
                int count = 0;//regular counter of consecutive ones

//              Loop through each digit in the binary. if its a '1' increment counter
                for (int j=0;j<binaryArr.length;j++){
                    if (binaryArr[j] == '1'){
                        count++;
                    }else if (binaryArr[j] == '0'){
//                      If the digit is a "0", check if the counter is greater than the max and update the max
                        if (count > max) {
                            max = count;
                        }
//                        reset counter
                            count = 0;

                    }
                }
//              At the end of the binary array. check again if the counter is greater than the max and update the max
                if (count > max) {
                    max = count;
                }
//              check if the max is greater than the outStanding Count and update
                if (max > outstandingCount){
                    outstandingCount = max;
                    outstandingTroop = myTroops[i];

                    outStandingBinary = binary;
                }


            }
        }
//        Print out the information
        System.out.println(outstandingTroop.GetTroopType()+", health="+outstandingTroop.GetHealth()+", Total Damage="+outstandingTroop.GetTotalDamage()+", Binary="+ outStandingBinary);

    }
}
