import javafx.scene.paint.Color; 
import java.util.List;

/**
 * This class models the behavior and state changes of a Pseudomonas cell.
 *
 * @author Aïda Tadlaoui and Chen Wang 
 * @version 2024.03.01
 */

public class Pseudomonas extends Cell {
    
    private int gen;
    
    /**
     * Create a new Pseudomonas.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Pseudomonas(Field field, Location location, Color col) {
        super(field, location, col);
        gen = 0;
    }

    /**
    * This is how the Pseudomonas decides if it's alive or not
    */
    public void act() {
        List<Cell> neighbours = getField().getLivingNeighbours(getLocation());
        setNextState(false);
        
        gen++ ;
        boolean isNeighbourDisease = false;
    
        if (isAlive() && !isInfected()) {
            // Check for infected neighbours
            for (Cell neighbour : neighbours) {
                if (neighbour.isInfected()) {
                    isNeighbourDisease = true;
                    break;
                }
            }
            // If near infected, become infected
            if (isNeighbourDisease) {
                setNextState(true);
                setInfected();
                setNextInfected(true);
                setColor(Color.BLACK);
            } 
            else if (gen <= 15) {
                // For the first 15 generations
                setNextState(true);
            } 
            else if (gen > 15 && gen <= 25) {
                // From generation 16 to 25
                if (neighbours.size() > 2) {
                    setNextState(true);
                }
            } 
            else {
                 // After generation 25
                setNextState(true);
                setColor(Color.YELLOW);
            }
        }
        else if (isInfected()) {
            if (neighbours.size() < 4) {
                setNextState(false);
            } 
            else {
                setNextState(true);
            }
        }
    }
}
