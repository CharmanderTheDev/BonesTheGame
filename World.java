import static java.lang.Math.*;
import java.util.*;

//IMPORTANT NOTE: THE GAME IS BEING SCALED DOWN FROM AN INFINITE WORLD TO A FINITE BUT CONSTANTLY LOADED AND SHIFTING ONE.
public class World {

    private static Ground[][] world = new Ground[256][256];

    public static Ground getSpot(Coords coords){
        if(inWorld(coords)){return(world[coords.getX()][coords.getY()]);}
        else{return(null);}
    }

    public static boolean inWorld(Coords coords){
        return(coords.getX()<256&&coords.getY()<256);
    }

    public static void transfer(Moveable object, Coords newCoords){
        //if it's not moving within the current world, it just wont move.
        if(inWorld(newCoords)){
            World.getSpot(newCoords).addObject(object);
            World.getSpot(object.getCoords()).removeObject(object);
            object.setCoords(newCoords); 
        }
    }

    public static Ground[] getAdjacent(Coords coords){
        Ground[] adjacent = new Ground[4];
        adjacent[0] = getSpot(new Coords(coords.getX(), coords.getY()+1));
        adjacent[1] = getSpot(new Coords(coords.getX(), coords.getY()-1));
        adjacent[2] = getSpot(new Coords(coords.getX()+1, coords.getY()));
        adjacent[3] = getSpot(new Coords(coords.getX()-1, coords.getY()));
        return(adjacent);
    }

    public static void tick(){
        for(int i=0;i<256;i++){
            for(int j=0;j<256;j++){
                world[i][j].tick();
            }
        }
        
        for(int i=0;i<256;i++){
            for(int j=0;j<256;j++){
                world[i][j].clearFlagged();
            }
        }       
    }

    public static void generateAll(){
        for(int i=0;i<256;i++){
            for(int j=0;j<256;j++){
                world[i][j] = new Dirt(0,0,0,0,0,0,0,0,new Coords(i,j));
                if(new Random().nextBoolean()){((Dirt) world[i][j]).addPlant(new Creep(0,0,0,0,null, new Coords(i,j)));}
                
            }
        }
        world[3][6].addObject(new Water(0,100,0,new Coords(3,6),world[3][6]));
    }
}


