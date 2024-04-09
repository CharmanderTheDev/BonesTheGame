import java.awt.*;
import java.util.*;

interface Alive extends Physical {
    /**
     * @return this.age, in ticks
     */
    public int getAge();
}

interface Avian extends Alive{
    /**
     * @return this.altitude, how high from the ground
     */
    public int getAltitude();
}

interface Consumer extends Animal{
    /**
     * @return this.consumedNutrients, the amount of nutrients an animal has access to
     */
    public int[] getConsumedNutrients();
}

interface Drawable extends Part{
    /**
     * @return a character that will represent the part in the game
     */
    public char drawChar();
    
    /**
     * @return the shade that the character representing the part will be in.
     */
    public Color drawColor();
}

interface Drug extends Physical {
    /**
     * affects the animal injesting/injecting/inhaling/contacting the drug in question.
     * @param e the animal to be affected
     */
    public void injested(Animal e);
    public void injected(Animal e);
    public void inhaled(Animal e);
    public void contacted(Animal e);
}

interface Edible extends Physical {
    /**
     * @return this.nutrients, the nutrients accessible to anyone consuming the object
     */
    public int[] getNutrients();
}

interface Flammable extends Physical{
    /**
     * @return the amount of fuel left in the object that can burn
     */
    public int getFuel();
}

interface Liquid extends Physical{
    /**
     * @return viscocity, or flow rate, of a given liquid
     */
    public int getViscocity();

    /**
     * @return the amount of said liquid (ml) in a given Liquid object
     */
    public int getAmount();
}

interface Part {

    /**
     * each part does what it does during a tick.
     */
    public void tick();
}

interface Physical extends Part{
    /**
     * @return the temperature of the object
     */
    public int getTemperature();

    /**
     * @return the weight of the object
     */
    public int getWeight();

    /**
     * @param perception a combination of range and the actual perception stat of the entity attempting to view the object
     * @return a set of strings, each a property of the object.
     */
    public String[] inspect(int perception);

    /** 
     * @return the coordinates of the object
     */
    public Coords getCoords();
}

interface Solid extends Physical{
    //**
      * @return an arraylist of liquids that the solid object is currently soaked in
      */
    public ArrayList<Liquid> getSoakedIn();

    /**
     * @return the structural integrity of the solid object, if applicable
     */
    public int getIntegrity();
}

interface Growable extends Physical {
    /**
     * @return the nutritional value for plants of a given physical object
     */
    public int getFertility();
}

interface Moveable extends Physical {
    /**
     * @param coords the coordinates you would like to set the object's coordinates to
     */
    public void setCoords(Coords coords);
}