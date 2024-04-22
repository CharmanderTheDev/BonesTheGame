public abstract class Liquid implements Physical, Drawable {
    
    public int amount;
    public int temperature;
    public int weight;
    public Coords coords;
    public Physical container;

    public Liquid(int temperature, int weight, int amount, Coords coords, Physical container){
        this.temperature = temperature;
        this.weight = weight;
        this.amount = amount;
        this.coords = coords;
        this.container = container;
    }

    public void flow(String type) {
        //flowing
        if(this.container instanceof Ground){
            int amountlower = 1;
            for(Ground ground: World.getAdjacent(this.coords)){
                if(ground.getHeight()<((Ground)this.container).getHeight()){amountlower++;}
            }if(this.amount/amountlower!=0){
            for(Ground ground: World.getAdjacent(this.coords)){
                if(ground.getHeight()<((Ground)this.container).getHeight()){
                    ground.addObject(LiquidFactory.getLiquid(type, this.temperature,this.weight/amountlower,this.amount/amountlower,ground.getCoords(),ground));
                }
            }this.amount = this.amount/amountlower;}
        }
    }

    public String[] inspect(int perception){
        return(new String[] {});
    }

    public int getTemperature(){
        return(this.temperature);
    }

    public int getWeight(){
        return(this.weight);
    }

    public int getAmount(){
        return(this.amount);
    }

    public Coords getCoords(){
        return(this.coords);
    }

    public Physical getContainer(){
        return(this.container);
    }

    public char drawChar(){
        return('\u2245');
    }
}
