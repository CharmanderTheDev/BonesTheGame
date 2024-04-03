import java.awt.*;
import java.util.*;

public class Dirt extends Ground implements Growable {
    
    protected int fertility;
    protected ArrayList<Plant> foliage;
    
    public Dirt(int fertility, int height, int temperature, int weight, int lifeForce, int warp, int vapors, int sunlight){
        super(height, temperature, weight, lifeForce, warp, vapors, sunlight);
        this.fertility = fertility;
    }

    public char drawChar(){return('-');}
    public Color drawColor(){return(new Color(150, 75, 0));}

    public void tick(ArrayList<ArrayList<Part>> world) {
        for(Plant plant : foliage){plant.tick(world);}
    }

    public String inspect(int perception) {
        return("");
    }

    public int getFertility(){return(this.fertility);}

    public void setFertility(int fertility){this.fertility = fertility;}
}
