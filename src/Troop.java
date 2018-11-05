import java.util.List;
/** Interface for a Troop.
 * @author Omotola Akeredolu
 */
public interface Troop {
    enum Types {GROUND,AIR}

    /**
     * This function handles what happens when the troop is attacked
     *
     * @param hitAmount The amount to be subtracted from the health
     */
    public void TakeHit(int hitAmount);


    /**
     * This function handles what happens when attacking an enemy troop
     *
     * @param enemyTroop The Troop that is being attacked
     */
    public void DoDamage(Troop enemyTroop);


    /**
     * This function retrieves troop type
     *
     * @return This Troop Type
     */
    public Army.TroopTypes GetTroopType();


    /**
     * This function sets health
     *
     * @param newHealth The newhealth
     */
    public void SetHealth(int newHealth);

    /**
     * This function retrieves the troop's health
     *
     * @return This troop's health
     */
    public int GetHealth();

    /**
     * This function retrieves the type
     *
     * @return Returns this troop's type
     */
    public Types GetType();

    /**
     * This function retrieves the accumulated damage over the rounds
     *
     * @return Returns this troop's total damage
     */
    public int GetTotalDamage();

    /**
     * This function retrieves the preferred target type
     *
     * @return Returns this troop's preferred target type
     */
    public List<Types> GetPreferredTarget();

    /**
     * This function checks if the troop is dead or not
     *
     * @return Returns True if the troop is dead or False if the troop is alive
     */
    public Boolean isDead();




}
