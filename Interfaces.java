import java.awt.*;
import java.util.*;

interface Alive extends Physical {
    public int getAge();
}

interface Avian extends Alive{
    public int getAltitude();
}

interface Carnivorous extends Consumer{}

interface Consumer extends Alive{
    public int[] getConsumedNutrients();
}

interface Drawable extends Part {
    public char drawChar();
    public Color drawColor();
}

interface Drug extends Physical {
    public void injested(Animal e);
    public void injected(Animal e);
    public void inhaled(Animal e);
    public void contacted(Animal e);
}

interface Edible extends Physical {
    public int[] getNutrients();
}

interface Flammable extends Physical{
    public int getFuel();
}

interface Liquid extends Physical{
    public int getViscocity();
    public int getAmount();
}

interface Part {
    public void tick(ArrayList<ArrayList<Part>> world);
}

interface Physical extends Part{
    public int getTemperature();
    public int getWeight();
    public String inspect(int perception);
}

interface Solid extends Physical{
    public ArrayList<Liquid> getSoakedIn();
    public int getIntegrity();
}

interface Growable extends Physical {
    public int getFertility();
}