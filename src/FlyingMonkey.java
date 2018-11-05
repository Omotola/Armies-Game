import java.util.Arrays;
import java.util.List;
/** Represents a Flying Monkey Troop.
 * @author Omotola Akeredolu
 */
public class FlyingMonkey extends MonkeyClass {
    Types type = Types.AIR;
    List<Types> preferredTarget = Arrays.asList(Types.AIR);

    @Override
    public Army.TroopTypes GetTroopType(){
        return Army.TroopTypes.FLYINGMONKEY;
    }
    @Override
    public List<Types> GetPreferredTarget(){
        return preferredTarget;
    }


    @Override
    public Types GetType(){
        return type;
    }
}
