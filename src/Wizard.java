import java.util.Arrays;
import java.util.List;
/** Represents a Wizard Troop.
 * @author Omotola Akeredolu
 */
public class Wizard implements Troop {
    Types type = Types.GROUND;
    int damage = 6;
    int health = 60;
    int totalDamageCounter = 0;
    List<Types> preferredTarget = Arrays.asList(Types.GROUND, Types.AIR);

    @Override
    public Army.TroopTypes GetTroopType(){
        return Army.TroopTypes.WIZARD;
    }

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
    public Types GetType(){
        return type;
    }

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

    @Override
    public List<Types> GetPreferredTarget(){
        return preferredTarget;
    }
}
