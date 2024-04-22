import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args){
        World.generateAll();
        World.getSpot(new Coords (0,0)).addObject(new Player(0,0,0,0, new Coords(0,0)));
        World.tick();
        while(true){
            World.tick();
            //displaying
            for(int i=0;i<16;i++){
                System.out.println();
                for(int j=0;j<16;j++){
                    System.out.print(World.getSpot(new Coords(i,j)).drawChar());
                }
            }
            //moving
            waitOne();
        }
    }
    //just allows us to decide when the tick will go
    public static void waitOne(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{reader.readLine();}catch(Exception e){}
    }
}