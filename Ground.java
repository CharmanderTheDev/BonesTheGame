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
    protected ArrayList<Physical> markedForRemoval;
    protected ArrayList<Physical> markedForAddition;

    protected Coords coords;

    public Ground(int height, int temperature, int weight, int lifeForce, int warp, int vapors, int sunlight, Coords coords) { 
        this.height = height;
        this.temperature = temperature;
        this.weight = weight;
        this.lifeForce = lifeForce;
        this.warp = warp;
        this.vapors = vapors;
        this.sunlight = sunlight;

        this.population = new ArrayList<Physical>();
        this.markedForRemoval = new ArrayList<Physical>();
        this.markedForAddition = new ArrayList<Physical>();

        this.coords = coords;
    }

    public int getHeight(){return(this.height);}
    public void setHeight(int height){this.height = height;}

    public int getTemperature(){return(this.temperature);}
    public void setTemperature(int temperature){this.temperature = temperature;}

    public int getWeight(){return(this.weight);}
    public void setWeight(int weight){this.weight = weight;}


    public int getLifeForce(){return(this.lifeForce);}
    public void setLifeForce(int lifeForce){this.lifeForce = lifeForce;}

    public int getWarp(){return(this.warp);}
    public void setWarp(int warp){this.warp = warp;}

    public int getVapors(){return(this.vapors);}
    public void setVapors(int vapors){this.vapors = vapors;}

    public int getSunlight(){return(this.sunlight);}
    public void setSunlight(){this.sunlight = sunlight;}
    
    public Coords getCoords(){return(this.coords);}

    
    /** 
     * @param includeFlagged whether or not to include objects that are flagged for deletion
     * @return the population of this Ground object
     */
    public ArrayList<Physical> getPopulation(boolean includeFlagged){
        if(includeFlagged){return(this.population);}
        else{
            ArrayList<Physical> cleanPopulation = this.population;
            for(Physical object: this.markedForRemoval){cleanPopulation.remove(object);}
            return(cleanPopulation);
        }
    }

    /**
     * marks object for addition at the end of a tick
     * @param object object to be added
     */
    public void addObject(Physical object){this.markedForAddition.add(object);}

    /**
     * marks object for deletion at the end of a tick
     * @param object object to be removed
     * @return the object that was passed in
     */
    public Physical removeObject(Physical object){this.markedForRemoval.add(object);return(object);}

    /**
     * clears the flagged lists, adding and removing objects. this prevents
     * concurrent modification errors by ensuring that all additions and removals
     * from the population happen AFTER the tick
     */
    public void clearFlagged(){
        for(Physical object: this.markedForRemoval){this.population.remove(object);}this.markedForRemoval.clear();
        for(Physical object: this.markedForAddition){this.population.add(object);}this.markedForAddition.clear();
    }
    
    public void combineLiquids(){
        for(Physical object: population){
            if(object instanceof Liquid && !this.markedForRemoval.contains(object)){
                for(int i=population.indexOf(object)+1;i<population.size();i++){
                    if(population.get(i).getClass()==object.getClass()){
                        ((Liquid) object).addAmount(((Liquid)population.get(i)).getAmount());
                        this.removeObject(population.get(i));
                    }
                }
            }
        }
    }

    public void tick(){
        this.combineLiquids();
        //Ticking objects
        for(Physical object: this.population){
            object.tick();
        }

    }
    //TODO: add liquid combining 

    /** 
     * draws entities & objects within this ground object based on a hierarchy as follows
     * Player > Animal > Plant > everything else
     * if there's nothing, it returns the null character, allowing its child (stone, dirt, etc)
     * to draw its own character
     * @return the character to be drawn
     */
    public char drawChar(){
        Class<?>[] classes = {Player.class, Water.class};
        for(Class<?> type: classes){for(Physical object: population){
            if(object.getClass() == type){return(((Drawable) object).drawChar());}
        }}
        return('\0');
    }
}