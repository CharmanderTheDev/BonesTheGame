public class World {
    
    private Chunk[][] world;

    //THIS "REFERENCE POSITION" WILL STORE THE COORDS IN THE ENTIRE WORLD
    private Coords reference;

    public World(){
        this.world = new Chunk[7][7];
    }

    public Ground getSpot(Coords coords){
        int x = coords.getX();
        int y = coords.getY();
        return(this.world[x/7][y/7].getSpot(new Coords(x%15, y%15)));
    }

    //TODO: IMPLEMENT LOADING CHUNK FILES
    public void loadFromCoords(Coords coords){
        //stops it from loading new chunks if the coordinates given are the same as before
        if(!coords.getChunk().equals(this.reference.getChunk())){

        }
        //sets the new coords
        this.reference = coords;
    }
}
