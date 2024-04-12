import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args){
        World.generateAll();
        World.getSpot(new Coords (0, 0)).addObject(new Player(0,0,0,0,new Coords(0,0),World.getSpot(new Coords(0,0))));
        while(true){
            //displaying
            for(int i=0;i<15;i++){
                System.out.println();
                for(int j=0;j<49;j++){
                    System.out.print(World.getSpot(new Coords(i,j)).drawChar());
                }
            }
            //moving
            waitOne();
            World.tick();
        }
    }
    //just allows us to decide when the tick will go
    public static void waitOne(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{reader.readLine();}catch(Exception e){}
    }
}