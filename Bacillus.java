import javafx.scene.paint.Color; 
import java.util.List;
import java.util.Random;

/**
 * This class models the behavior and state changes of a Bacillus cell.
 *
 * @author Aïda Tadlaoui and Chen Wang 
 * @version 2024.03.01
 */

public class Bacillus extends Cell {
    
    private static final double R1 = 0.3;
    private static final double R2 = 0.5;
    private static final double R3 = 0.8;
    private Random rand = new Random();
    
    /**
     * Create a new Bacillus.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Bacillus(Field field, Location location, Color col) {
        super(field, location, col);
    }

    /**
    * This is how the Bacillus decides if it's alive or not
    */
    public void act() {
        List<Cell> neighbours = getField().getLivingNeighbours(getLocation());
        setNextState(false);
        
        double prob = rand.nextDouble();
        boolean isNeighbourDisease = false;
        
        if (isAlive() && !isInfected()) {
            // Search for infected neighbours
            for (Cell neighbour : neighbours) {
                if (neighbour.isInfected()) {
                    isNeighbourDisease = true;
                    break;
                }
            }
            // Infect this cell if an infected neighbour is found
            if (isNeighbourDisease) {
                setNextState(true);
                setInfected();
                setNextInfected(true);
                setColor(Color.BLACK);
            } 
            else {
                // Determine next state based on random probability
                if (prob <= R1) {
                    setNextState(true);
                } 
                else if (prob <= R2) {
                    setNextState(true);
                    setColor(Color.GREY);
                } 
                else if (prob <= R3) {
                    setNextState(true);
                    setColor(Color.PINK);
                } 
                else {
                    setNextState(true);
                }
            }
        }
        else if (isInfected()) {
            // Determine survival of infected cells based on neighbour count
            if (neighbours.size() < 4) {
                setNextState(false);
            } 
            else {
                setNextState(true);
            }
        }
    }
}
