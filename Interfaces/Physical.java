import java.util.*;

interface Physical extends Part{
    public int getTemperature();
    public int getWeight();
    public String inspect(int perception, int range);
}