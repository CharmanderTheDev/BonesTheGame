public abstract class Leviathan {
    
    private int x;
    private int y;

    public Leviathan(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){return(this.x);}
    public int getY(){return(this.y);}

    public abstract void affect();
}
