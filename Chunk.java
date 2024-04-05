import java.util.*;

public class Chunk {
    
    protected Ground[][] ground;
    protected ArrayList<Leviathan> leviathans;

    public Chunk() {
        this.ground = new Ground[15][15];
        this.leviathans = new ArrayList<Leviathan>();
    }

    public void generateChunk(Chunk tChunk, Chunk dChunk, Chunk lChunk, Chunk rChunk){

    }

    public void generateChunk(){
        for(int i=0;i<15;i++){for(int j=0;j<15;j++){this.ground[i][j] = new Dirt(0,0,0,0,0,0,0,0);}}
    }

    public Ground getSpot(Coords coords){return(this.ground[coords.getX()][coords.getY()]);}
}