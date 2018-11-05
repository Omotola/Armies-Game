import java.util.List;
/** Abstract Class for Monkey and Flying Monkey.
 * @author Omotola Akeredolu
 */
public abstract class MonkeyClass implements Troop {

    int damage = 6;
    int health = 50;
    int totalDamageCounter = 0;

    @Override
    public abstract  List<Types>  GetPreferredTarget();;
    @Override
    public abstract Army.TroopTypes GetTroopType();

    @Override
    public void TakeHit(int hitAmount){
        int newhealth = health - hitAmount;
        SetHealth(newhealth);
    }

    @Override
    public void DoDamage(Troop enemyTroop){
        int enemyPrevHealth = enemyTroop.GetHealth();
        int damageToGive = damage;
//        Calculate How much damage to give
        if (!GetPreferredTarget().contains(enemyTroop.GetType())){
            damageToGive/=2;

        }
        int damageUpdate = damageToGive;

//        Enemy Take Hit
        enemyTroop.TakeHit(damageToGive);


//        Check if enemy is dead and cap the totaldamage increase by the enemy's health
        if (enemyTroop.isDead()){
            damageUpdate=enemyPrevHealth;
        }


        totalDamageCounter+=damageUpdate;

    }
    @Override
    public void SetHealth(int newHealth){
        health = newHealth;
    }

    @Override
    public int GetHealth(){
        return health;
    }

    @Override
    public abstract Types GetType();

    @Override
    public int GetTotalDamage(){
        return totalDamageCounter;
    }

    @Override
    public Boolean isDead(){
        if(health<=0){
            return true;
        }
        return false;
    }


}
