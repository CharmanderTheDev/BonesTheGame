import java.util.*;

interface Solid extends Physical{
    public ArrayList<Liquid> getSoakedIn();
    public int getIntegrity();
}