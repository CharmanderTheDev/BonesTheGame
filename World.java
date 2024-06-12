import static java.lang.Math.*;
import java.util.*;

//IMPORTANT NOTE: THE GAME IS BEING SCALED DOWN FROM AN INFINITE WORLD TO A FINITE BUT CONSTANTLY LOADED AND SHIFTING ONE.
public class World {
    static enum MoonPhase{CONCEPTION,BIRTH,GROWTH,TENURE,DEATH}
    static MoonPhase moonPhase = MoonPhase.GROWTH;
    static enum SunPhase{DEAD,SPARKING,GLOWING,BURNING,DYING}
    static SunPhase sunPhase = SunPhase.BURNING;

    static boolean dayTime = true;

    //DEBUGGING TOOLS
    public static final boolean printChaserCoords = false;
    public static final boolean printChaserFinds = false;
    public static final boolean printSight = false;
    public static final boolean printSunPhase = true;
    public static final boolean printMoonPhase = true;
    public static final boolean printTemperature = true;
    public static final boolean printTotalTemp = true;
    public static final boolean printTime = true;
    public static final boolean printAverageTemp = true;

    public static int age;

    private static Ground[][] world = new Ground[256][256];

    public static Ground getSpot(Coords coords){
        if(inWorld(coords)){return(world[coords.getX()][coords.getY()]);}
        else{return(null);}
    }

    public static boolean inWorld(Coords coords){
        return(coords.getX()<256&&
               coords.getY()<256&&
               coords.getX()>-1&&
               coords.getY()>-1);
    }

    public static void transfer(Moveable object, Coords newCoords){
        //if it's not moving within the current world, it just wont move.
        if(inWorld(newCoords)){
            World.getSpot(newCoords).addObject(object);
            World.getSpot(object.getCoords()).removeObject(object);
            object.setCoords(newCoords); 
        }
    }

    public static Ground[] getAround(Coords coords, int range){
        Ground[][] around = new Ground[(range*2)+1][(range*2)+1];
        //Looping through "around"
        for(int i=coords.getX()-range;i<coords.getX()+range;i++){for(int j=coords.getY()-range;j<coords.getY()+range;j++){
            if(((int)Coords.distance(new Coords(i,j), coords))<=range){around[i-(coords.getX()-range)][j-(coords.getY()-range)]=getSpot(new Coords(i,j));}
        }}

        //converting "around" to a 1d list
        Ground[] aroundlist = new Ground[((range*2)+1)*((range*2)+1)];
        for(int i=0;i<(range*2)+1;i++){if(printSight){System.out.println();}for(int j=0;j<(range*2)+1;j++){
            if(printSight){System.out.print(around[i][j]==null?"X":(around[i][j].contains(Player.class)?"!":"O"));}
            aroundlist[(i*((range*2)+1))+j] = around[i][j];
        }}
        return(aroundlist);
    }

    public static Ground[] getAdjacent(Coords coords){
        Ground[] adjacent = new Ground[4];
        adjacent[0] = getSpot(new Coords(coords.getX(), coords.getY()+1));
        adjacent[1] = getSpot(new Coords(coords.getX(), coords.getY()-1));
        adjacent[2] = getSpot(new Coords(coords.getX()+1, coords.getY()));
        adjacent[3] = getSpot(new Coords(coords.getX()-1, coords.getY()));
        return(adjacent);
    }


    public static Coords chase(Physical chaser, Physical chased){
        int dx = chased.getCoords().getX() - chaser.getCoords().getX();
        int dy = chased.getCoords().getY() - chaser.getCoords().getY();
        return(new Coords(chaser.getCoords().getX()+Helper.reduce(dx), chaser.getCoords().getY()+Helper.reduce(dy)));
    }

    public static void tick(){
        age++;
        int totaltemp = 0;

        //phaseManager();

        for(int i=0;i<256;i++){
            for(int j=0;j<256;j++){
                world[i][j].tick();
                totaltemp+=world[i][j].getTemperature();
            }
        }
        
        for(int i=0;i<256;i++){
            for(int j=0;j<256;j++){
                world[i][j].clearFlagged();
            }
        }     

        if(printSunPhase){System.out.println("Sun phase: "+sunPhase);}
        if(printMoonPhase){System.out.println("Moon phase: "+moonPhase);}
        if(printTotalTemp){System.out.println("Total temperature: "+totaltemp);}
        if(printTime){System.out.println(dayTime?"Daytime":"Nighttime");}
        if(printAverageTemp){System.out.println("Average temperature: "+totaltemp/(256.0*256.0));}
    }

    

    public static void phaseManager(){
        
        if(age%50==0){dayTime = !dayTime;}

        if(age%150==0){
            if(MoonPhase.values()[4]==moonPhase){moonPhase = MoonPhase.CONCEPTION;}
            else{
                mainLoop:for(int i=0;i<4;i++){if(moonPhase==MoonPhase.values()[i]){moonPhase = MoonPhase.values()[i+1];break mainLoop;}}
            }}

        if(age%5000==0){
            if(SunPhase.values()[4]==sunPhase){sunPhase = SunPhase.DEAD;}
            else{
                mainLoop:for(int i=0;i<4;i++){if(sunPhase==SunPhase.values()[i]){sunPhase = SunPhase.values()[i+1];break mainLoop;}}
            }}
    }

    public static double sin2(double a){
        return(Math.sin(a)*Math.sin(a));
    }

    public static double getSunlight() {
        return(
            //Day/Night multiplier
            sin2((Math.PI*age)/1000) *
            //Season multiplier
            switch(sunPhase){
                case BURNING -> .8;
                case DEAD -> 0;
                case DYING -> 2;
                case GLOWING -> .4;
                case SPARKING -> 0;
                default -> 1;
                
            }
        );
    }

    public static MoonPhase getMoonPhase(){return(moonPhase);}
    public static SunPhase getSunPhase(){return(sunPhase);}

    public static void generateAll(){
        int[][] fertilitynoise = NoiseGen.getNoise(256, 0, 8, 0, Integer.MIN_VALUE);
        int[][] heightnoise = NoiseGen.getNoise(256, 8, 8, Integer.MAX_VALUE, Integer.MIN_VALUE);
        for(int i=0;i<256;i++){
            for(int j=0;j<256;j++){
                //Generating the ground
                world[i][j] = new Dirt(fertilitynoise[i][j], heightnoise[i][j], 0, 10000, 0, 0, 0, new Coords(i,j));
                
                //Adding the plants
                if(new Random().nextBoolean()){((Dirt) world[i][j]).addPlant(new Creep(10, 0, new Coords(i,j)));}
                
                //Adding the water
                if(world[i][j].getHeight()<6){world[i][j].addObject(new Water(10,10,68,new Coords(i,j), world[i][j]));}
                
                //Adding the chasers
                if(Math.random()>.999){world[i][j].addObject(new Chaser(0,0,0,0, new Coords(i,j)));}
            }
        }
    }
}


