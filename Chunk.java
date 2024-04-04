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

    public void generateChunk(){
        for(int i=0;i<16;i++){for(int j=0;j<16;j++){this.ground[i][j] = new Dirt(0,0,0,0,0,0,0,0);}}
    }

    public Ground getSpot(int x, int y){return(this.ground[x][y]);}
}