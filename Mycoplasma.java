import javafx.scene.paint.Color; 
import java.util.List;
import java.util.Random;

/**
 * Simplest form of life.
 * Fun Fact: Mycoplasma are one of the simplest forms of life.  A type of
 * bacteria, they only have 500-1000 genes! For comparison, fruit flies have
 * about 14,000 genes.
 *
 * @author David J. Barnes, Michael Kölling, Jeffery Raphael, Chen Wang and Aïda Tadlaoui
 * @version 2024.03.01
 */

public class Mycoplasma extends Cell {

    private static final double PROB_DISEASE = 0.08; // The probability of Mycoplasma getting infected by disease
    private Random rand = new Random();

    /**
     * Create a new Mycoplasma.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Mycoplasma(Field field, Location location, Color col) {
        super(field, location, col);
    }

    /**
    * This is how the Mycoplasma decides if it's alive or not.
    */
    public void act() {
        List<Cell> neighbours = getField().getLivingNeighbours(getLocation());
        setNextState(false);
    
        double disease = rand.nextDouble(); 
        
        // During daytime
        if (Simulator.isDay()) {
            if (isAlive() && !isInfected()) {
                setColor(Color.LIGHTBLUE);
                // Cell becomes infected with a probability
                if (disease <= PROB_DISEASE) {
                   setNextState(true);
                   setInfected(); // Marks the cell as infected
                   setNextInfected(true); // Prepares infection status for next cycle
                   setColor(Color.BLACK);
                } 
                else if (neighbours.size() < 2 || neighbours.size() > 3) {
                    setNextState(false);
                } 
                else {
                    setNextState(true);
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
            else if (!isAlive()){
                if (neighbours.size() == 3) {
                    setNextState(true);
                }
            }
        } 
        // During nighttime
        else {
            if (isAlive() && !isInfected()) {
                setNextState(true);
                setColor(Color.DARKBLUE);
            } 
            else if (isInfected()) {
                setNextState(true);
            }
        }
    }
}

