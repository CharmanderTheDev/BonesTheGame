import java.util.*;

abstract class Ground implements Physical, Drawable {

    protected int struck;

    protected int height;
    protected double temperature;
    protected double weight;
    
    protected double lifeForce;
    protected double warp;
    protected double vapors;

    protected ArrayList<Physical> population;
    protected ArrayList<Physical> markedForRemoval;
    protected ArrayList<Physical> markedForAddition;

    protected Coords coords;

    public Ground(int height, double temperature, double weight, double lifeForce, double warp, double vapors, Coords coords) { 
        this.height = height;
        this.temperature = temperature;
        this.weight = weight;
        this.lifeForce = lifeForce;
        this.warp = warp;
        this.vapors = vapors;

        this.population = new ArrayList<Physical>();
        this.markedForRemoval = new ArrayList<Physical>();
        this.markedForAddition = new ArrayList<Physical>();

        this.coords = coords;
        this.struck = -1;
    }

    public int getHeight(){return(this.height);}
    public void setHeight(int height){this.height = height;}

    public double getTemperature(){return(this.temperature);}
    public void setTemperature(int temperature){this.temperature = temperature;}
    public void addTemperature(double temperature){this.temperature += temperature;}

    public double getWeight(){return(this.weight);}
    public void setWeight(double weight){this.weight = weight;}


    public double getLifeForce(){return(this.lifeForce);}
    public void setLifeForce(double lifeForce){this.lifeForce = lifeForce;}

    public double getWarp(){return(this.warp);}
    public void setWarp(double warp){this.warp = warp;}

    public double getVapors(){return(this.vapors);}
    public void setVapors(double vapors){this.vapors = vapors;}
    
    public Coords getCoords(){return(this.coords);}

    public boolean contains(Class<?> type){
        for(Physical object: this.population){
            if(object.getClass() == type){return(true);}
        }return(false);
    }

    public Physical getType(Class<?> type){
        for(Physical object: this.population){
            if(object.getClass()==type){return(object);}
        }return(null);
    }
    
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

    public void spark(){
        if(Math.random()>.9999&&this.struck==-1){this.struck=5;}
    }

    public void manageTemperature(){
        //Sunlight temp manager
        this.temperature += World.getSunlight() * 3;

        //Dispersion
        this.temperature -= .001 * (Math.pow(this.temperature-World.getSunlight(), 2));

        //disperses a further 10% outward
        int total = 0;
        for(Ground ground: World.getAdjacent(this.coords)){
            if(ground!=null){total++;}
        }
        for(Ground ground: World.getAdjacent(this.coords)){
            if(ground!=null){ground.addTemperature(this.temperature/(10*total));}
        }this.temperature = (this.temperature * 9) / 10;

        //Sparking manager
        if(this.struck>0){this.struck--;}
        if(this.struck==0){this.struck=-1;this.temperature=1000;}
    }

    public void tick(){
        this.manageTemperature();
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
        //Drawing the struck marker
        if(this.struck>0){return('O');}
        
        //Drawing all the stuff on it
        Class<?>[] classes = {Player.class, Chaser.class, Water.class};
        for(Class<?> type: classes){for(Physical object: population){
            if(object.getClass() == type){return(((Drawable) object).drawChar());}
        }}

        return('\0');
    }
}