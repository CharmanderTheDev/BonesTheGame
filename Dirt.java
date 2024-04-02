import java.awt.*;
import java.util.*;

public class Dirt extends Ground implements Growable {
    
    protected int fertility;
    protected ArrayList<Plant> foliage;
    
    public Dirt(int fertility, int height, int temperature, int weight, int lifeForce, int warp, int vapors, int sunlight){
        this.fertility = fertility;
        this.height = height;
        this.temperature = temperature;
        this.weight = weight;
        this.lifeForce = lifeForce;
        this.warp = warp;
        this.vapors = vapors;
        this.sunlight = sunlight;
    }

    public char drawChar(){return('-');}
    public Color drawColor(){return(new Color(150, 75, 0));}

    public void tick(ArrayList<ArrayList<Part>> world) {

    }

    public String inspect(int perception) {
        return("");
    }

    public int getFertility(){return(this.fertility);}

}
