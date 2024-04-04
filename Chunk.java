import java.util.*;

public class Chunk {
    
    protected Ground[][] ground;
    protected ArrayList<Leviathan> leviathans;

    public Chunk() {
        this.ground = new Ground[16][16];
        this.leviathans = new ArrayList<Leviathan>();
    }

    public void generateChunk(Chunk tChunk, Chunk dChunk, Chunk lChunk, Chunk rChunk){
        
    }
}