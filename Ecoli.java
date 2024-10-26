import javafx.scene.paint.Color; 
import java.util.List;

/**
 * This class models the behavior and state changes of a Ecoli cell.
 *
 * @author Aïda Tadlaoui (k23090130) & Chen Wang (k23008656)
 * @version 2024.03.01
 */

public class Ecoli extends Cell {

    /**
     * Create a new Ecoli.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Ecoli(Field field, Location location, Color col) {
        super(field, location, col);
    }

    /**
    * This is how the Ecoli decides if it's alive or not
    */
    public void act() {
        List<Cell> neighbours = getField().getLivingNeighbours(getLocation());
        boolean isStaphNeighbour = false;
    
        // Check for the presence of Staph cells among neighbours
        for (Cell neighbour : neighbours) {
            if (neighbour instanceof Staph) {
                isStaphNeighbour = true;
                break;
            }
        }
        
        if (isStaphNeighbour) {
            setNextState(false);
        } 
        else {
            setNextState(true);
        }
    }
}
