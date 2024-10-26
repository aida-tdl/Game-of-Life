import javafx.scene.paint.Color; 
import java.util.List;

/**
 * This class models the behavior and state changes of a Staph cell.
 *
 * @author Aïda Tadlaoui (k23090130) & Chen Wang (k23008656)
 * @version 2024.03.01
 */

public class Staph extends Cell {

    /**
     * This class models the behavior and state changes of a Staph cell.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Staph(Field field, Location location, Color col) {
        super(field, location, col);
    }

    /**
    * This is how the Staph decides if it's alive or not
    */
    public void act() {
        List<Cell> neighbours = getField().getLivingNeighbours(getLocation());
        setNextState(false);
        
        // During daytime
        if (Simulator.isDay()) {
            if (isAlive()) {
                setNextState(true);
                setColor(Color.LIGHTGREEN);
            } 
            else if (neighbours.size() == 6) {
                setNextState(true);
                setColor(Color.LIGHTGREEN);
            }
        } 
        // During nighttime
        else {
            if (isAlive()) {
                setNextState(true);
                setColor(Color.DARKGREEN);
            } 
        }
    }
}