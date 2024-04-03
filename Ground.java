import java.util.*;

abstract class Ground implements Physical, Drawable {

    protected int height;
    protected int temperature;
    protected int weight;
    
    protected int lifeForce;
    protected int warp;
    protected int vapors;
    protected int sunlight;

    protected ArrayList<Animal> population;

    public Ground(int height, int temperature, int weight, int lifeForce, int warp, int vapors, int sunlight) { 
        this.height = height;
        this.temperature = temperature;
        this.weight = weight;
        this.lifeForce = lifeForce;
        this.warp = warp;
        this.vapors = vapors;
        this.sunlight = sunlight;
    }

    public int getHeight(){return(this.height);}
    public int getTemperature(){return(this.temperature);}
    public int getWeight(){return(this.weight);}
    
    public int getLifeForce(){return(this.lifeForce);}
    public int getWarp(){return(this.warp);}
    public int getVapors(){return(this.vapors);}
    public int getSunlight(){return(this.sunlight);}

    public ArrayList<Animal> getPopulation(){return(this.population);}
}