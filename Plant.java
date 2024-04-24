abstract class Plant implements Alive, Drawable {
    
    public static int plantCount;
    protected int age;
    protected int weight;
    protected int temperature;
    protected int fertility;
    protected int germination;
    protected Drug drug;
    protected Coords coords;


    public Plant(int age, int weight, int temperature, int fertility, int germination, Drug drug, Coords coords){
        plantCount++;
        this.age = age;
        this.weight = weight;
        this.temperature = temperature;
        this.fertility = fertility;
        this.germination = germination;
        this.drug = drug;
        this.coords = coords;
    }

    public int getAge(){return(this.age);}
    public int getWeight(){return(this.weight);}
    public int getTemperature(){return(this.temperature);}
    public int getFertility(){return(this.fertility);}

    public void transfer(){}

    public void tick(){

    }

    public void spread(String type){
        if(Math.random()<(1.0/this.germination)){
            Ground newGround = World.getAdjacent(this.coords)[(int)(Math.random()*4)];
            if(newGround!=null&&((Dirt) newGround).getFertilitySum()>this.fertility){((Dirt) newGround).addPlant(PlantFactory.getPlant(type, 0, newGround.getTemperature(), newGround.getCoords()));}
        }
    }

    public String[] inspect(int perception){
        return(new String[] {});
    }

    public Coords getCoords(){return(this.coords);}
}
