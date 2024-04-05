abstract class Animal implements Consumer, Edible {

    protected BodyPart[] bodyparts;

    //Alive, Sapient, Physical
    protected int age;
    protected int sanity;
    protected int weight;
    protected int temperature;
    protected Coords coords;

    //Carnivorous, Consumer
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
        this.bodyparts = new BodyPart[] 
        {
            
        };

        this.age = age;
        this.sanity = sanity;
        this.weight = weight;
        this.temperature = temperature;
        this.coords = coords;
    }

    public int[] getStats() {
        int[] fullStats = {0, 0, 0};
        for(BodyPart bodypart: bodyparts){
            for(int i: new int[] {0,1,2}){fullStats[i] += bodypart.getStats()[i];}
        }
        return(fullStats);
    }

    //Stats returning
    public int getSpeed(){return(this.getStats()[0]);}
    public int getStrength(){return(this.getStats()[1]);}
    public int getPerception(){return(this.getStats()[2]);}

    public int getAge(){return(this.age);}
    public int getSanity(){return(this.sanity);}
    public int getWeight(){return(this.weight);}
    public int getTemperature(){return(this.temperature);}

    public int[] getConsumedNutrients(){return(new int[] {this.consumedCarbs,this.consumedFungi,this.consumedRoots,this.consumedFat,this.consumedMeat});}

    public int[] getNutrients(){return(new int[] {this.carbs,this.fungi,this.roots,this.fat,this.meat});}

    //TODO: implement inspect
    public String inspect(int perception){return("");}

    //TODO: implement tick
    public void tick(){}

}