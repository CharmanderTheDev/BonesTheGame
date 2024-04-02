class Plant implements Alive {
    
    protected int age;
    protected int weight;
    protected int temperature;

    public Plant(int age, int weight, int temperature){
        this.age = age;
        this.weight = weight;
        this.temperature = temperature;
    }

    public int getAge(){return(this.age);}
    public int getWeight(){return(this.weight);}
    public int getTemperature(){return(this.temperature);}
}
