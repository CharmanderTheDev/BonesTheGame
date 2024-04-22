import java.awt.*;

public class Stone extends Ground{
    
    protected int fertility;
    
    public Stone(int height, int temperature, int weight, int lifeForce, int warp, int vapors, int sunlight, Coords coords){
        super(height, temperature, weight, lifeForce, warp, vapors, sunlight, coords);
    }

    public char drawChar(){return('\u2261');}
    public Color drawColor(){return(new Color(150, 75, 0));}

    
    /** 
     * @param world
     */
    public void tick(World world) {

    }

    
    /** 
     * @param perception
     * @return String[]
     */
    public String[] inspect(int perception) {
        return(new String[] {});
    }
}