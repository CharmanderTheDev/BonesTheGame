import java.awt.Color;

public class Basin extends Ground {
    
    private Liquid liquid;

    public Basin(int height, int temperature, int weight, int lifeForce, int warp, int vapors, int sunlight, Coords coords, Liquid liquid){
        super(0,temperature,weight,lifeForce,warp,vapors,sunlight,coords);
        this.liquid = liquid;
    }

    public char drawChar(){
        if(this.liquid!=null){return(this.liquid.drawChar());}
        else{return('\u26DA');}
    }

    @Override
    public String[] inspect(int perception) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inspect'");
    }
    
    public Color drawColor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawColor'");
    }

}
