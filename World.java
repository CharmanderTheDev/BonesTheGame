import static java.lang.Math.*;

public class World {
    
    private static Chunk[][] world = new Chunk[7][7];

    //THIS "REFERENCE POSITION" WILL STORE THE COORDS IN THE ENTIRE WORLD
    private static Coords reference = new Coords(0,0);

    public static Ground getSpot(Coords coords){
        int x = coords.getX();
        int y = coords.getY();
        return(world[x/7][y/7].getSpot(new Coords(x%15, y%15)));
    }

    //TODO: IMPLEMENT LOADING CHUNK FILES, TRY-CATCH OF LOADING AND GENERATING
    public static void loadFromCoords(Coords coords){
        //stops it from loading new chunks if the coordinates given are the same as before
        if(!coords.getChunk().equals(reference.getChunk())){

        }
        //sets the new coords
        reference = coords;
    }

    public static boolean inCurrentWorld(Coords coords){
        return(abs(coords.getX()-reference.getX())<=52&&abs(coords.getY()-reference.getY())<=52);
    }

    public static void transfer(Moveable object, Coords newCoords){
        //TODO: make it move around the player
        
        //if it's not moving within the current world, it has to bring a hardsaved chunk into memory to add it.
        if(inCurrentWorld(newCoords)){
            World.getSpot(newCoords).addObject(object);
        }
    }

    public static void tick(){
        for(int i=0;i<7;i++){
            System.out.println();
            for(int j=0;j<7;j++){
                world[i][j].tick();
            }
        }
        
        for(int i=0;i<7;i++){
            System.out.println();
            for(int j=0;j<7;j++){
                world[i][j].clearFlagged();
            }
        }       
    }

    public static void generateAll(){
        for(int i=0;i<7;i++){
            System.out.println();
            for(int j=0;j<7;j++){
                world[i][j] = new Chunk();
                world[i][j].generateChunk();
            }
        }
    }
}
