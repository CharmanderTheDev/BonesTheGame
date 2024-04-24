import java.awt.*;

public class Creep extends Plant {
    
    public Creep(int age, int temperature, Coords coords){
        super(age, 1, temperature, 1, 2, null, coords);
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

    public void tick(){
        super.tick();
        this.spread("Creep");
    }
}
