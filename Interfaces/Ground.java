import java.util.*;

interface Ground extends Physical{
    public int getHeight();
    public ArrayList<Entity> getPopulation();
    public int getSunlight();
    public int getVapors();
    public int getWarp();
    public int getLifeforce();
    public String[][] draw(String[][] board);
}