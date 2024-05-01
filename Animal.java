abstract class Animal implements Consumer, Edible, Moveable, Drawable {

    protected BodyPart[] bodyparts;

    //Variables mandated by...
        //Alive, Sapient, Physical, Moveable
        protected int age;
        protected int sanity;
        protected double weight;
        protected double temperature;
        protected Coords coords;

        //Consumer
        protected int consumedCarbs;
        protected int consumedFungi;
        protected int consumedRoots;
        protected int consumedFat;
        protected int consumedMeat;

        //Consumable
        protected int carbs;
        protected int fungi;
        protected int roots;
        protected int fat;
        protected int meat;

    public Animal(int age, int sanity, int weight, int temperature, Coords coords){
        //initializes the bodypart list, also easy to copy-paste.
        this.bodyparts = new BodyPart[] 
        {
            
        };

        this.age = age;
        this.sanity = sanity;
        this.weight = weight;
        this.temperature = temperature;
        this.coords = coords;
    }

    
    /** 
     * @return int[]
     */
    public int[] getStats() {
        int[] fullStats = {0, 0, 0};
        for(BodyPart bodypart: bodyparts){
            for(int i: new int[] {0,1,2}){fullStats[i] += bodypart.getStats()[i];}
        }
        return(fullStats);
    }

    /**
     * @return first element of this.stats, corresponding to speed
     */
    public int getSpeed(){return(this.getStats()[0]);}

    /**
     * @return second element of this.stats, corresponding to strength
     */
    public int getStrength(){return(this.getStats()[1]);}

    /**
     * @return third element of this.stats, corresponding to perception
     */
    public int getPerception(){return(this.getStats()[2]);}

    public int getAge(){return(this.age);}

    /**
     * @return this.sanity
     */
    public int getSanity(){return(this.sanity);}

    public double getWeight(){return(this.weight);}
    public double getTemperature(){return(this.temperature);}
    
    public int[] getConsumedNutrients(){return(new int[] {this.consumedCarbs,this.consumedFungi,this.consumedRoots,this.consumedFat,this.consumedMeat});}
    
    public int[] getNutrients(){return(new int[] {this.carbs,this.fungi,this.roots,this.fat,this.meat});}

    //TODO: implement inspect
    public String[] inspect(int perception){
        return(new String[] {});
    }

    //TODO: implement tick
    public void tick(){}

    public Coords getCoords(){return(this.coords);}
    public void setCoords(Coords coords){this.coords = coords;}
    public void transfer(Coords coords){World.transfer(this, coords);}

    protected Ground[] getSight(){
        return(World.getAround(this.coords, this.getPerception()));
    }
}