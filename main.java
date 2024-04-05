class Main {
    public static void main(String[] args){
        World.generateAll();
        World.getSpot(new Coords (0, 0)).addObject(new Player(0,0,0,0,new Coords(0,0)));
        while(true){
            //displaying
            for(int i=0;i<15;i++){
                System.out.println();
                for(int j=0;j<15;j++){
                    System.out.print(World.getSpot(new Coords(i,j)).drawChar());
                }
            }
            //moving
            World.tick();
        }
    }
}