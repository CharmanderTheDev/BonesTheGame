import java.awt.*;
import java.util.*;

public class Dirt extends Ground implements Growable {
    
    protected int fertility;
    protected ArrayList<Plant> foliage;
    
    public Dirt(int fertility, int height, int temperature, int weight, int lifeForce, int warp, int vapors, int sunlight, Coords coords, Chunk chunk){
        super(height, temperature, weight, lifeForce, warp, vapors, sunlight, coords, chunk);
        this.fertility = fertility;
    }

    public char drawChar(){
        if(super.drawChar()!='\0'){return(super.drawChar());}
        return('#');
    }
    public Color drawColor(){return(new Color(150, 75, 0));}

    public void tick() {
        super.tick();
        for(Plant plant : foliage){plant.tick();}
    }

    public String inspect(int perception) {
        return("");
    }

    public int getFertility(){return(this.fertility);}

    public void setFertility(int fertility){this.fertility = fertility;}

    public void addFoliage(Plant plant){this.foliage.add(plant);}

    public Plant removeFoliage(Plant plant){this.foliage.remove(plant);return(plant);}
}
