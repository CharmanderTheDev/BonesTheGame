import java.util.*;

abstract class Plant implements Alive {
    
    protected int age;
    protected int weight;
    protected int temperature;
    Dirt dirt;

    public Plant(int age, int weight, int temperature){
        this.age = age;
        this.weight = weight;
        this.temperature = temperature;
    }

    public int getAge(){return(this.age);}
    public int getWeight(){return(this.weight);}
    public int getTemperature(){return(this.temperature);}

    public void setDirt(Dirt dirt){this.dirt = dirt;}

    public void tick(ArrayList<ArrayList<Part>> world){

    }

    public String inspect(int perception){
        return("");
    }
}
