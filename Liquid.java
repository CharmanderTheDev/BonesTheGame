public abstract class Liquid implements Physical, Drawable {
    
    public int amount;
    public double temperature;
    public double weight;
    public Coords coords;
    public Physical container;

    public Liquid(double temperature, double weight, int amount, Coords coords, Physical container){
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
            for(Ground ground: World.getAdjacent(this.coords)){if(ground!=null){
                if(ground.getHeight()<=((Ground)this.container).getHeight()){amountlower++;}}
            }if(this.amount/amountlower!=0){
            for(Ground ground: World.getAdjacent(this.coords)){if(ground!=null){
                if(ground.getHeight()<=((Ground)this.container).getHeight()){
                    ground.addObject(LiquidFactory.getLiquid(type, this.weight/amountlower,this.amount/amountlower,this.temperature,ground.getCoords(),ground));
                }
            }}this.amount = this.amount/amountlower;}
            //System.out.println(amountlower);
        }
    }

    public String[] inspect(int perception){
        return(new String[] {});
    }

    public double getTemperature(){
        return(this.temperature);
    }

    public double getWeight(){
        return(this.weight);
    }

    public int getAmount(){
        return(this.amount);
    }

    public void setAmount(int amount){
        this.amount=amount;
    }

    public void addAmount(int amount){
        this.amount+=amount;
    }

    public Coords getCoords(){
        return(this.coords);
    }

    public Physical getContainer(){
        return(this.container);
    }

    public char drawChar(){
        return('\u2248');
    }

    public void tick(){
        //System.out.println(this.amount);
    }
}
