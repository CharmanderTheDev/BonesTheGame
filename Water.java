import java.awt.Color;

public class Water extends Liquid {
    
    public Water(double weight, int amount, double temperature, Coords coords, Physical container){
        super(temperature,weight,amount,coords,container);
    }

    public String[] inspect(int perception) {
        return(new String[] {});
    }

    public Color drawColor() {
        return(new Color(0,0,255));
    }

    @Override
    public void tick(){
        super.tick();
        //super.flow("Water");
    }
}
