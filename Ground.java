import java.util.*;

abstract class Ground implements Physical, Drawable {

    protected int height;
    protected int temperature;
    protected int weight;
    
    protected int lifeForce;
    protected int warp;
    protected int vapors;
    protected int sunlight;

    protected ArrayList<Physical> population;

    protected Coords coords;
    protected Chunk chunk;

    public Ground(int height, int temperature, int weight, int lifeForce, int warp, int vapors, int sunlight, Coords coords, Chunk chunk) { 
        this.height = height;
        this.temperature = temperature;
        this.weight = weight;
        this.lifeForce = lifeForce;
        this.warp = warp;
        this.vapors = vapors;
        this.sunlight = sunlight;
        this.population = new ArrayList<Physical>();
        this.coords = coords;
        this.chunk = chunk;
    }

    public int getHeight(){return(this.height);}
    public int getTemperature(){return(this.temperature);}
    public int getWeight(){return(this.weight);}
    
    public int getLifeForce(){return(this.lifeForce);}
    public int getWarp(){return(this.warp);}
    public int getVapors(){return(this.vapors);}
    public int getSunlight(){return(this.sunlight);}
    
    public Coords getCoords(){return(this.coords);}

    public ArrayList<Physical> getPopulation(){return(this.population);}

    public void addObject(Physical object){this.population.add(object);}

    public Physical removeObject(Physical object){this.population.remove(object);return(object);}

    public void transfer(Physical object, Coords newCoords){this.chunk.transfer(object, newCoords);}

    public void tick(){
        for(Physical object: population){object.tick();}
    }

    public char drawChar(){
        for(Physical object: population){
            if(object instanceof Player){
                return(((Drawable) object).drawChar());
            }
        }
        return('\0');
    }
}