public class Coords {
    
    private int x;
    private int y;

    public Coords(int x, int y){
        this.x = x;
        this.y = y;
    }

    //converts a chunk and the relative coordinates within the chunk into fullcoords
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

    public Coords getChunk(){
        return(new Coords(this.x/15, this.y/15));
    }

    public boolean equals(Coords coords){
        return((coords.getX()==this.getX())&&(coords.getY()==this.getY()));
    }
}
