import javafx.scene.paint.Color; 

/**
 * A class representing the shared characteristics of all forms of life
 *
 * @author David J. Barnes, Michael Kölling, Jeffery Raphael, Chen Wang and Aïda Tadlaoui
 * @version 2024.03.01
 */

public abstract class Cell {

    private boolean alive;    
    private boolean nextAlive; // The state of the cell in the next iteration
    private Field field;
    private Location location;
    private Color color = Color.WHITE;
    private boolean infected; // Whether the cell is infected with the disease
    private boolean nextInfected; // Whether the cell in it's next state is still infected with disease

    /**
     * Create a new cell at location in field.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Cell(Field field, Location location, Color col) {
        alive = true;
        nextAlive = false;
        this.field = field;
        setLocation(location);
        setColor(col);
        infected = false;
    }

    /**
     * Make this cell act - that is: the cell decides it's status in the
     * next generation.
     */
    abstract public void act();

    /**
     * Check whether the cell is alive or not.
     * @return true if the cell is still alive.
     */
    protected boolean isAlive() {
        return alive;
    }
    
    /**
     * Check whether the cell is infected or not.
     * @return true if the cell is infected.
     */
    protected boolean isInfected() {
        return infected;
    }

    /**
     * Indicate that the cell is no longer alive.
     */
    protected void setDead() {
        alive = false;
    }

    /**
     * Indicate that the cell will be alive or dead in the next generation.
     */
    public void setNextState(boolean value) {
        nextAlive = value;
    }

    /**
     * Indicate that the cell is infected with disease.
     */
    protected void setInfected() {
        infected = true;
    }
    
    /**
     * Indicate whether the cell will be infected or not with disease in the next generation.
     */
    public void setNextInfected(boolean value) {
        nextInfected = value;
    }
    
    /**
     * Changes the state of the cell.
     */
    public void updateState() {
        alive = nextAlive;
    }
    
    /**
     * Changes the color of the cell.
     */
    public void setColor(Color col) {
        color = col;
    }

    /**
     * Returns the cell's color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Return the cell's location.
     * @return The cell's location.
     */
    protected Location getLocation() {
        return location;
    }

    /**
     * Place the cell at the new location in the given field.
     * @param location The cell's location.
     */
    protected void setLocation(Location location) {
        this.location = location;
        field.place(this, location);
    }

    /**
     * Return the cell's field.
     * @return The cell's field.
     */
    protected Field getField() {
        return field;
    }
}
