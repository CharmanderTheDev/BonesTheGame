import java.util.*;

public class Chunk {
    
    /**
     * a 2d list of the ground objects in the chunk
     */
    protected Ground[][] ground;

    /**
     * the leviathans in the chunk
     */
    protected ArrayList<Leviathan> leviathans;

    /**
     * the coordinates of the chunk in the chunk-grid
     */
    protected Coords coords;

    public Chunk(Coords coords) {
        this.ground = new Ground[15][15];
        this.leviathans = new ArrayList<Leviathan>();
        this.coords = coords;
    }

    /**
     * generates a chunk based on the coordinates of the chunk and the seed
     * @param coords the coordinates of the chunk to be generated
     * @param seed the seed of the World
     */
    public void generateChunk(Coords coords, int seed){

    }

    /**
     * fills chunk with basic dirt
     */
    public void generateChunk(){
        for(int i=0;i<15;i++){for(int j=0;j<15;j++){this.ground[i][j] = new Dirt(0,0,0,0,0,0,0,0, new Coords(i+(this.coords.getX()*15),j+(this.coords.getY())), this);}}
    }

    /**
     * @param coords the coordinates of the spot desired within the chunk
     * @return the Ground object at the coordinates specified
     */
    public Ground getSpot(Coords coords){return(this.ground[coords.getX()][coords.getY()]);}

    /**
     * @return the chunk-grid coordinates of this chunk
     */
    public Coords getCoords(){return(this.coords);}

    /**
     * ticks every ground object in the chunk
     */
    public void tick(){
        for(int i=0;i<15;i++){
            System.out.println();
            for(int j=0;j<15;j++){
                this.getSpot(new Coords(i,j)).tick();
            }
        }       
    }

    public void clearFlagged(){
        for(int i=0;i<15;i++){
            System.out.println();
            for(int j=0;j<15;j++){
                this.getSpot(new Coords(i,j)).clearFlagged();
            }
        }   
    }
}