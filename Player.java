import java.util.*;

class Player implements Ambulatory, Seeing, Able, Sapient {

    private BodyPart rLeg; private BodyPart lLeg;
    private BodyPart rArm; private BodyPart lArm; 
    private BodyPart rLung; private BodyPart lLung;
    private BodyPart heart; private BodyPart rEye;
    private BodyPart lEye; private BodyPart head;

    private BodyPart[] bodyparts;

    private int age;
    private int sanity;
    private int weight;
    private int temperature;

    public Player(int age, int sanity, int weight, int temperature){
        this.rLeg = new BodyPart("right leg", 1, 0, 0); this.lLeg = new BodyPart("left leg", 1, 0, 0); 
        this.rArm = new BodyPart("right arm", 0, 1, 0); this.lArm = new BodyPart("left arm", 0, 1, 0);
        this.rLung = new BodyPart("right lung", 1, 1, 0); this.lLung = new BodyPart("left lung", 1, 1, 0);
        this.heart = new BodyPart("heart", 1, 1, 1); this.rEye = new BodyPart("right eye", 0, 0, 1);
        this.lEye = new BodyPart("left eye", 0, 0, 1); this.head = new BodyPart("head", 0, 0, 1);
        
        this.bodyparts = new BodyPart[] 
        {this.rLeg, this.lLeg, this.rArm, this.lArm, this.rLung, 
        this.lLung, this.heart, this.rEye, this.lEye, this.head};

        this.age = age;
        this.sanity = sanity;
        this.weight = weight;
        this.temperature = temperature;
    }

    public int[] getStats() {
        int[] fullStats = {0, 0, 0};
        for(BodyPart bodypart: bodyparts){
            for(int i: new int[] {0,1,2}){fullStats[i] += bodypart.getStats()[i];}
        }
        return(fullStats);
    }


    public int getSpeed(){return(this.getStats()[0]);}
    public int getStrength(){return(this.getStats()[1]);}
    public int getPerception(){return(this.getStats()[2]);}

    public int getAge(){return(this.age);}
    public int getSanity(){return(this.sanity);}
    public int getWeight(){return(this.weight);}
    public int getTemperature(){return(this.temperature);}

    //TODO: implement inspect
    public String inspect(int perception, int range){return("");}

    //TODO: implement tick
    public void tick(ArrayList<ArrayList<Part>> world){}

}