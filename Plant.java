abstract class Plant implements Alive, Drawable {
    
    protected int age;
    protected int weight;
    protected int temperature;
    protected int fertility;
    protected Drug drug;
    protected Coords coords;


    public Plant(int age, int weight, int temperature, int fertility, Drug drug, Coords coords){
        this.age = age;
        this.weight = weight;
        this.temperature = temperature;
        this.fertility = fertility;
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

    public String[] inspect(int perception){
        return(new String[] {});
    }

    public Coords getCoords(){return(this.coords);}
}
