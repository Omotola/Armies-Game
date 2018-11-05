import java.util.Arrays;
import java.util.List;
/** Represents a Monkey Troop.
 * @author Omotola Akeredolu
 */
public class Monkey extends MonkeyClass {
    Types type = Types.GROUND;
    List<Types> preferredTarget = Arrays.asList(Types.GROUND);

    @Override
    public Army.TroopTypes GetTroopType(){
        return Army.TroopTypes.MONKEY;
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

