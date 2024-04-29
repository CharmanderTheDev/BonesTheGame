import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args){
        World.generateAll();
        World.getSpot(new Coords (8,8)).addObject(new Player(0,0,0,0, new Coords(8,8)));
        World.getSpot(new Coords (5,5)).addObject(new Chaser(0,0,0,0, new Coords(5,5)));
        while(true){
            //displaying
            for(int i=0;i<16;i++){
                System.out.println();
                for(int j=0;j<16;j++){
                    System.out.print(World.getSpot(new Coords(i,j)).drawChar());
                }
            }
            //moving
            World.tick();
            waitOne();
        }
        //int[][] noise = NoiseGen.getNoise(40);
        //for(int i=0;i<40;i++){System.out.println();for(int j=0;j<40;j++){System.out.print(noise[i][j]);}}
    }
    //just allows us to decide when the tick will go
    public static void waitOne(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{reader.readLine();}catch(Exception e){}
    }
}