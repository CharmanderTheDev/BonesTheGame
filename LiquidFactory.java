public class LiquidFactory {
    
    public static Liquid getLiquid(String type, int weight, int amount, int temperature, Coords coords, Physical container){
        if(type.equals("Water")){
            return(new Water(weight, amount, temperature, coords, container));
        }

        else{return(null);}
    }
}
