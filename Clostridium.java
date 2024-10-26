import javafx.scene.paint.Color; 
import java.util.List;
import java.util.Random;

/**
 * This class models the behavior and state changes of a Clostridium cell.
 *
 * @author Aïda Tadlaoui and Chen Wang 
 * @version 2024.03.01
 */

public class Clostridium extends Cell {
    
    private static final double PROB_DISEASE = 0.08; // The probability of Clostridium getting infected by disease
    private Random rand = new Random();

    /**
     * Create a new Clostridium.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Clostridium(Field field, Location location, Color col) {
        super(field, location, col);
    }

    /**
    * This is how the Clostridium decides if it's alive or not
    */
    public void act() {
        
        List<Cell> neighbours = getField().getLivingNeighbours(getLocation());
        setNextState(false);
        
        double disease = rand.nextDouble();
        
        if (isAlive() && !isInfected()) {
            // Cell becomes infected with a probability
            if (disease <= PROB_DISEASE) {
               setNextState(true); 
               setInfected(); // Marks the cell as infected
               setNextInfected(true); // Prepares infection status for next cycle
               setColor(Color.BLACK);
            } 
            else if (neighbours.size() == 3) {
                setNextState(true);
                setColor(Color.RED);
            } 
            else if (neighbours.size() == 1) {
                setNextState(true);
            } 
        } 
        else if (isInfected()) {
            if (neighbours.size() < 4) {
                setNextState(false);
            } else {
                setNextState(true);
            }
        } else if (!isAlive()) {
            if (neighbours.size() == 2) {
                setNextState(true);
                setColor(Color.ORANGE);
            }
        }
    }
}
