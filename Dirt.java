import java.awt.*;
import java.util.*;

public class Dirt extends Ground implements Growable {
    
    protected int fertility;

    protected ArrayList<Plant> foliage;
    protected ArrayList<Plant> plantMarkedForRemoval;
    protected ArrayList<Plant> plantMarkedForAddition;
    
    public Dirt(int fertility, int height, int temperature, int weight, int lifeForce, int warp, int vapors, int sunlight, Coords coords, Chunk chunk){
        super(height, temperature, weight, lifeForce, warp, vapors, sunlight, coords, chunk);
        this.fertility = fertility;
        this.foliage = new ArrayList<Plant>();
        this.plantMarkedForRemoval = new ArrayList<Plant>();
        this.plantMarkedForAddition = new ArrayList<Plant>();
    }

    @Override
    public char drawChar(){
        if(super.drawChar()!='\0'){return(super.drawChar());}
        return('#');
    }
    public Color drawColor(){return(new Color(150, 75, 0));}

    /**
     * uses Ground.tick, and then ticks all the plants in foliage.
     */
    public void tick() {
        super.tick();
        for(Plant plant : foliage){plant.tick();}
    }

    public String[] inspect(int perception) {
        return(new String[] {});
    }

    public int getFertility(){return(this.fertility);}

    public void setFertility(int fertility){this.fertility = fertility;}

    /**
     * marks plant for addition at the end of a tick
     * @param plant plant to be added
     */
    public void addPlant(Plant plant){this.plantMarkedForAddition.add(plant);}

    /**
     * marks plant for deletion at the end of a tick
     * @param plant object to be removed
     * @return the plant that was passed in
     */
    public Plant removePlants(Plant plant){this.plantMarkedForRemoval.add(plant);return(plant);}

    /**
     * clears the flagged lists, adding and removing plants & objects. this prevents
     * concurrent modification errors by ensuring that all additions and removals
     * from the population/foliage happen AFTER the tick
     */
    @Override
    public void clearFlagged(){
        super.clearFlagged();
        for(Plant plant: this.plantMarkedForRemoval){this.foliage.remove(plant);}
        for(Plant plant: this.plantMarkedForAddition){this.foliage.add(plant);}
    }
}
