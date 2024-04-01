import java.util.*;

class Player extends Animal {

    //Body parts
    private BodyPart rLeg; private BodyPart lLeg;
    private BodyPart rArm; private BodyPart lArm; 
    private BodyPart rLung; private BodyPart lLung;
    private BodyPart heart; private BodyPart rEye;
    private BodyPart lEye; private BodyPart head;

    public Player(int age, int sanity, int weight, int temperature){
        super(age, sanity, weight, temperature);
        
        this.rLeg = new BodyPart("right leg", 500, 0, 0); this.lLeg = new BodyPart("left leg", 500, 0, 0); 
        this.rArm = new BodyPart("right arm", 0, 500, 0); this.lArm = new BodyPart("left arm", 0, 500, 0);
        this.rLung = new BodyPart("right lung", 1000, 1000, 0); this.lLung = new BodyPart("left lung", 1000, 1000, 0);
        this.heart = new BodyPart("heart", 1000, 1000, 1000); this.rEye = new BodyPart("right eye", 0, 0, 500);
        this.lEye = new BodyPart("left eye", 0, 0, 500); this.head = new BodyPart("head", 0, 0, 1000);
        
        this.bodyparts = new BodyPart[]
        {
        this.rLeg, this.lLeg, this.rArm, this.lArm, this.rLung, 
        this.lLung, this.heart, this.rEye, this.lEye, this.head
        };

    }

    //TODO: implement inspect
    public String inspect(int perception, int range){
        return("");
    }

    //TODO: implement tick
    public void tick(ArrayList<ArrayList<Part>> world) {
        
    }

}