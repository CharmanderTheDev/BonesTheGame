import java.awt.*;

public class Chaser extends Animal{

    private BodyPart rLeg; private BodyPart lLeg;
    private BodyPart rArm; private BodyPart lArm; 
    private BodyPart rLung; private BodyPart lLung;
    private BodyPart heart; private BodyPart rEye;
    private BodyPart lEye; private BodyPart head;


    public Chaser(int age, int sanity, int weight, int temperature, Coords coords){
        super(age, sanity, weight, temperature, coords);
        
        this.rLeg = new BodyPart("right leg", 500, 0, 0, this); this.lLeg = new BodyPart("left leg", 500, 0, 0, this); 
        this.rArm = new BodyPart("right arm", 0, 500, 0, this); this.lArm = new BodyPart("left arm", 0, 500, 0, this);
        this.rLung = new BodyPart("right lung", 1000, 1000, 0, this); this.lLung = new BodyPart("left lung", 1000, 1000, 0, this);
        this.heart = new BodyPart("heart", 1000, 1000, 0, this); this.rEye = new BodyPart("right eye", 0, 0, 1, this);
        this.lEye = new BodyPart("left eye", 0, 0, 1, this); this.head = new BodyPart("head", 0, 0, 3, this);
        
        this.bodyparts = new BodyPart[]
        {
        this.rLeg, this.lLeg, this.rArm, this.lArm, this.rLung, 
        this.lLung, this.heart, this.rEye, this.lEye, this.head
        };
    }

    public void tick(){
        if(World.printChaserCoords){System.out.println("I'm a chaser! My coordinates are "+Coords.toString(this.coords));}
        super.tick();
        Ground[] sight = this.getSight();
        for(Ground ground: sight){if(ground!=null&&
            ground.contains(Player.class)){
            if(Math.random()>0.5){this.transfer(World.chase(this, ground.getType(Player.class)));}
        }}
    }

    public char drawChar(){
        return('!');
    }

    public Color drawColor(){
        return(new Color(0,0,0));
    }
}

