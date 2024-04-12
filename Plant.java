abstract class Plant implements Alive {
    
    protected int age;
    protected int weight;
    protected int temperature;
    protected Drug drug;
    Dirt dirt;

    public Plant(int age, int weight, int temperature, Drug drug){
        this.age = age;
        this.weight = weight;
        this.temperature = temperature;
        this.drug = drug;
    }

    public int getAge(){return(this.age);}
    public int getWeight(){return(this.weight);}
    public int getTemperature(){return(this.temperature);}

    public void transfer(){}

    public void tick(){

    }

    public String[] inspect(int perception){
        return(new String[] {});
    }
}
