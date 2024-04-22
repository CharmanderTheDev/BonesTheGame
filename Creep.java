import java.awt.*;

public class Creep extends Plant {
    
    public Creep(int age, int weight, int temperature, int fertility, Drug drug, Coords coords){
        super(age, weight, temperature, fertility, drug, coords);
    }

    public char drawChar(){
        return('#');
    }

    public Color drawColor(){
        return(new Color(255,0,255));
    }

    public String[] inspect(int perception){
        return(super.inspect(perception));
    }
}
