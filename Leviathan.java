public abstract class Leviathan {
    
    private Coords coords;

    public Leviathan(Coords coords){
        this.coords = coords;
    }

    public Coords getCoords(){return(this.coords);}

    public abstract void affect();
}
