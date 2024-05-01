public class LiquidFactory {
    
    public static Liquid getLiquid(String type, double weight, int amount, double temperature, Coords coords, Physical container){
        if(type.equals("Water")){
            return(new Water(weight, amount, temperature, coords, container));
        }

        else{return(null);}
    }
}
