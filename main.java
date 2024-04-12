import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args){
        World.generateAll();
        World.getSpot(new Coords (new Coords(4, 4), new Coords(8, 8))).addObject(Player.getInstance());
        while(true){
            World.tick();
            //displaying
            for(int i=0;i<15;i++){
                System.out.println();
                for(int j=0;j<15;j++){
                    System.out.print(World.getSpot(new Coords(new Coords(4, 4), new Coords(i,j))).drawChar());
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