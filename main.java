import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args){
        World.generateAll();
        Player player = new Player(0,0,0,0, new Coords(8,8));
        World.getSpot(new Coords (8,8)).addObject(player);
        for(int i=0;i<0;i++){World.getSpot(new Coords (5,5)).addObject(new Chaser(0,0,0,0, new Coords(5,5)));}
        while(true){

            //displaying
            Ground[] world = World.getAround(player.getCoords(), 10);
            for(int i=0;i<21;i++){
                System.out.println();
                for(int j=0;j<21;j++){
                    Ground spot = world[(i*21)+j];
                    System.out.print(
                        spot==null?" ":spot.drawChar()
                    );
                }
            }
            //moving
            //waitOne(player);
            World.tick();

        }
        //int[][] noise = NoiseGen.getNoise(40);
        //for(int i=0;i<40;i++){System.out.println();for(int j=0;j<40;j++){System.out.print(noise[i][j]);}}
    }
    //just allows us to decide when the tick will go
    public static void waitOne(Player player){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{String move = reader.readLine();
            if(move.equals("w")){player.direction = Player.Direction.UP;}
            if(move.equals("a")){player.direction = Player.Direction.LEFT;}
            if(move.equals("s")){player.direction = Player.Direction.DOWN;}
            if(move.equals("d")){player.direction = Player.Direction.RIGHT;}
            if(move.equals(" ")){player.direction = Player.Direction.STILL;}
        }catch(Exception e){}
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}