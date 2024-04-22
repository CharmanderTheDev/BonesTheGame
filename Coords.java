public class Coords {
    
    private int x;
    private int y;

    public Coords(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * create a new Coords object from the coordinates of a chunk, and coordinates within that chunk
     * @param chunk chunk in which chunkpos is in
     * @param chunkpos coordinates within param chunk
     */
    public Coords(Coords chunk, Coords chunkpos){
        this.x = (chunk.getX()*15)+chunkpos.getX();
        this.y = (chunk.getY()*15)+chunkpos.getY();
    }

    public int getX(){
        return(this.x);
    }

    public int getY(){
        return(this.y);
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    /**
     * @return the chunk of a coordinates object
     */
    public Coords getChunk(){
        return(new Coords(this.x/15, this.y/15));
    }

    /**
     * @param coords the coordinates to compare with
     * @return a boolean stating if the two coordinate objects are equal
     */
    public boolean equals(Coords coords){
        return((coords.getX()==this.getX())&&(coords.getY()==this.getY()));
    }

    public static String toString(Coords coords){
        return("x"+Integer.toString(coords.getX())+"y"+Integer.toString(coords.getY()));
    }
}
