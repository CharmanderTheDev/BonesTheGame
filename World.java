import static java.lang.Math.*;

//IMPORTANT NOTICE: ALL COORDS OBJECTS SHOULD FROM NOW ON REFER TO WORLDCOORDS, ONLY ANONYMOUS AND TEMPORARY ONES SHOULD BE OTHERWISE. THIS SHOULD SIMPLIFY THINGS

public class World {
    
    private static Chunk[][] world = new Chunk[7][7];

    public static Ground getSpot(Coords coords){
        int x = coords.getX();
        int y = coords.getY();
        return(world[x/7][y/7].getSpot(new Coords(x%15, y%15)));
    }

    //TODO: IMPLEMENT LOADING CHUNK FILES, TRY-CATCH OF LOADING AND GENERATING
    public static void loadFromCoords(Coords coords){
        //stops it from loading new chunks if the coordinates given are the same as before
        if(!coords.getChunk().equals(Player.getInstance().getCoords().getChunk())){

        }
        //sets the new coords
    }

    public static boolean inCurrentWorld(Coords coords){
        int refX = Player.getInstance().getCoords().getX();
        int refY = Player.getInstance().getCoords().getY();
        return(abs(refX-coords.getX())<=52&&52>=abs(coords.getY()-refY));
    }

    public static void transfer(Moveable object, Coords newCoords){
        //checks if object is the player, and if the world needs to load new chunks
        if(object instanceof Player){
            if(newCoords.getChunk().equals(world[4][4].getCoords())){
                World.getSpot(newCoords).addObject(object);
            }
        }
        
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
                world[i][j] = new Chunk(new Coords(i,j));
                world[i][j].generateChunk();
            }
        }
    }
}
