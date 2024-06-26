import java.awt.*;

class Player extends Animal {

    //moving
    enum Direction{UP,DOWN,LEFT,RIGHT,STILL}
    public Direction direction = Direction.LEFT;

    //Body parts
    private BodyPart rLeg; private BodyPart lLeg;
    private BodyPart rArm; private BodyPart lArm; 
    private BodyPart rLung; private BodyPart lLung;
    private BodyPart heart; private BodyPart rEye;
    private BodyPart lEye; private BodyPart head;


    public Player(int age, int sanity, int weight, int temperature, Coords coords){
        super(age, sanity, weight, temperature, coords);
        
        this.rLeg = new BodyPart("right leg", 500, 0, 0, 16000, 1, this); this.lLeg = new BodyPart("left leg", 500, 0, 0, 16000, 1, this); 
        this.rArm = new BodyPart("right arm", 0, 500, 0, 4000, 1, this); this.lArm = new BodyPart("left arm", 0, 500, 0, 4000, 1, this);
        this.rLung = new BodyPart("right lung", 1000, 1000, 0, 1000, 0, this); this.lLung = new BodyPart("left lung", 1000, 1000, 0, 1000, 0, this);
        this.heart = new BodyPart("heart", 1000, 1000, 1000, 400, 2, this); this.rEye = new BodyPart("right eye", 0, 0, 500, 5, 0, this);
        this.lEye = new BodyPart("left eye", 0, 0, 500, 5, 0, this); this.head = new BodyPart("head", 0, 0, 1000, 4000, 2, this);
        
        this.bodyparts = new BodyPart[]
        {
        this.rLeg, this.lLeg, this.rArm, this.lArm, this.rLung, 
        this.lLung, this.heart, this.rEye, this.lEye, this.head
        };
    }

    //TODO: implement inspect
    public String[] inspect(int perception){
        return(new String[] {});
    }

    //TODO: implement tick
    public void tick() {
        Ground newGround = null;
        if(this.direction==Direction.UP){newGround = World.getAdjacent(this.coords)[3];}
        if(this.direction==Direction.DOWN){newGround = World.getAdjacent(this.coords)[2];}
        if(this.direction==Direction.LEFT){newGround = World.getAdjacent(this.coords)[1];}
        if(this.direction==Direction.RIGHT){newGround = World.getAdjacent(this.coords)[0];}
        if(this.direction==Direction.STILL){newGround = World.getSpot(this.coords);}
        this.transfer(newGround!=null?newGround.getCoords():this.coords);
        if(World.getSpot(this.coords).contains(Chaser.class)){System.out.println("you died!");}
        if(World.printTemperature){System.out.println("Temperature at player's feet: "+World.getSpot(this.coords).getTemperature());}
    }

    public char drawChar(){return('@');}
    public Color drawColor(){return(new Color(255,0,0));}
}