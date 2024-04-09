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
        for(int i=0;i<15;i++){for(int j=0;j<15;j++){this.ground[i][j] = new Dirt(0,0,0,0,0,0,0,0, new Coords(i,j), this);}}
    }

    public Ground getSpot(Coords coords){return(this.ground[coords.getX()][coords.getY()]);}

    public void transfer(Moveable object, Coords newCoords){World.transfer(object, newCoords);}

    public void tick(){
        for(int i=0;i<15;i++){
            System.out.println();
            for(int j=0;j<15;j++){
                this.getSpot(new Coords(i,j)).tick();
            }
        }       
    }
}