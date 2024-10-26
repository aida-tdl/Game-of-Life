import javafx.scene.paint.Color; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * A Life (Game of Life) simulator, first described by British mathematician
 * John Horton Conway in 1970.
 *
 * @author David J. Barnes, Michael Kölling, Jeffery Raphael, Chen Wang and Aïda Tadlaoui
 * @version 2024.03.01
 */

public class Simulator {
    
    private static final double MYCOPLASMA_ALIVE_PROB = 0.25;
    private static final double CLOSTRIDIUM_ALIVE_PROB = 0.20;
    private static final double PSEUDOMONAS_ALIVE_PROB = 0.25;
    private static final double BACILLUS_ALIVE_PROB = 0.15;
    private static final double ECOLI_ALIVE_PROB = 0.10;
    private static final double STAPH_ALIVE_PROB = 0.10;
    private List<Cell> cells;
    private Field field;
    private int generation;
    private static boolean isDay = true;
    private static final int dayNightCycle = 5;
    private static int dayNightCounter = 0;

    /**
     * Construct a simulation field with default size.
     */
    public Simulator() {
        this(SimulatorView.GRID_HEIGHT, SimulatorView.GRID_WIDTH);
    }

    /**
     * Create a simulation field with the given size.
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width) {
        cells = new ArrayList<>();
        field = new Field(depth, width);
        reset();
    }

    /**
     * Run the simulation from its current state for a single generation.
     * Iterate over the whole field updating the state of each life form.
     */
    public void simOneGeneration() {
        generation++;
        dayNightCounter++;
        
        // Check if the current day-night cycle is complete
        if (dayNightCounter >= dayNightCycle) {
            isDay = !isDay;
            dayNightCounter = 0;
        }
        
        for (Iterator<Cell> it = cells.iterator(); it.hasNext(); ) {
            Cell cell = it.next();
            cell.act();
        }

        for (Cell cell : cells) {
          cell.updateState();
        }
    }
    
    /**
     * Reset the simulation to a starting position.
     */
    public void reset() {
        generation = 0;
        cells.clear();
        populate();
    }

    /**
     * Randomly populate the field with live/dead life forms
     */
    private void populate() {
        Random rand = Randomizer.getRandom();
        field.clear();
      
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Location location = new Location(row, col);
                if (rand.nextDouble() <= MYCOPLASMA_ALIVE_PROB) {
                    Mycoplasma myco = new Mycoplasma(field, location, Color.LIGHTBLUE);
                    cells.add(myco);
                } 
                else if (rand.nextDouble() <= CLOSTRIDIUM_ALIVE_PROB) {
                    Clostridium clos = new Clostridium(field, location, Color.MAGENTA);
                    cells.add(clos);
                } 
                else if (rand.nextDouble() <= PSEUDOMONAS_ALIVE_PROB) {
                    Pseudomonas pseu = new Pseudomonas(field, location, Color.PURPLE);
                    cells.add(pseu);
                } 
                else if (rand.nextDouble() <= BACILLUS_ALIVE_PROB) {
                    Bacillus baci = new Bacillus(field, location, Color.BROWN);
                    cells.add(baci);
                } 
                else if (rand.nextDouble() <= ECOLI_ALIVE_PROB) {
                    Ecoli ecol = new Ecoli(field, location, Color.BISQUE);
                    cells.add(ecol);
                } 
                else if (rand.nextDouble() <= STAPH_ALIVE_PROB) {
                    Staph stap = new Staph(field, location, Color.LIGHTGREEN);
                    cells.add(stap);
                } 
                else {
                    Mycoplasma myco = new Mycoplasma(field, location, Color.LIGHTBLUE);
                    myco.setDead();
                    cells.add(myco);
                    Clostridium clos = new Clostridium(field, location, Color.MAGENTA);
                    clos.setDead();
                    cells.add(clos);
                    Pseudomonas pseu = new Pseudomonas(field, location, Color.PURPLE);
                    pseu.setDead();
                    cells.add(pseu);
                    Bacillus baci = new Bacillus(field, location, Color.BROWN);
                    baci.setDead();
                    cells.add(baci);
                    Ecoli ecol = new Ecoli(field, location, Color.BISQUE);
                    ecol.setDead();
                    cells.add(ecol);
                    Staph stap = new Staph(field, location, Color.LIGHTGREEN);
                    stap.setDead();
                    cells.add(stap);
                }
            }
        }
    }

    /**
     * Pause for a given time.
     * @param millisec  The time to pause for, in milliseconds.
     */
    public void delay(int millisec) {
        try {
            Thread.sleep(millisec);
        }
        catch (InterruptedException ie) {
            // wake up
        }
    }
    
    /**
     * Returns the field.
     */
    public Field getField() {
        return field;
    }

    /**
     * Returns the generation.
     */
    public int getGeneration() {
        return generation;
    }
    
    /**
     * Returns whether or not it is day.
     * If false, it is night.
     */
    public static boolean isDay() {
        return isDay;
    }
}
