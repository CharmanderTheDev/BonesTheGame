import java.awt.Color;

public class Water extends Liquid {
    
    public Water(int weight, int amount, int temperature, Coords coords, Physical container){
        super(temperature,weight,amount,coords,container);
    }

    public String[] inspect(int perception) {
        return(new String[] {});
    }

    public Color drawColor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawColor'");
    }

}
