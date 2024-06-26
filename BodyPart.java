import java.util.*;

class BodyPart implements Solid{
    
    //Variables needed for this class specifically
        public String name;
        private int moveSpeed;
        private int strength;
        private int perception;
        private ArrayList<Effect> effects;

    //Variables mandated by interfaces
        private double weight;
        private int integrity;
        private ArrayList<Liquid> soakedIn;

    //Subparts 
        

    /**
     * the animal to which this BodyPart belongs.
     */
    private Animal animal;

    public BodyPart(String name, int moveSpeed, int strength, int perception, double weight, int integrity, Animal animal){
        this.name = name;
        this.moveSpeed = moveSpeed;
        this.strength = strength;
        this.perception = perception;
        this.weight = weight;
        this.integrity = integrity;
        this.effects = new ArrayList<Effect>();
        this.animal = animal;
    }
    
    
    /** 
     * adds effect to the bodypart
     * @param effect the effect to add to the bodypart
     */
    public void effect(Effect effect){
        this.effects.add(effect);
    }


    /** 
     * removes effects based on matching keywords
     * @param keywords the list of healing keywords
     */
    public void heal(ArrayList<String> keywords) {
        effectLoop:
        for(Effect effect: effects) {
            for(String keyword: keywords) {
                if(effect.keywords.contains(keyword)) {
                    effects.remove(effect);
                    continue effectLoop;
                }
            }
        }
    }

    
    /** 
     * applies effects to stats and returns the resulting "effective stats"
     * @return int[] the stats of this bodypart when considering effects
     */
    public int[] getStats(){
        int effectiveMoveSpeed = this.moveSpeed;
        int effectiveStrength = this.strength;
        int effectivePerception = this.perception;

        for(Effect effect : effects) {
            effectiveMoveSpeed += effect.moveSpeed;
            effectiveStrength += effect.strength;
            effectivePerception += effect.perception;
        }

        return(new int[] {effectiveMoveSpeed, effectiveStrength, effectivePerception});
    }
    
    /*
    Body parts modify in 3 ways: moveSpeed, strength, perception.
    this function should return these 3, taking into account it's own injuries. 
    moveSpeed: determines the tiles per turn you can move over 1000
    strength: modifies how many turns it takes for actions over 1000
    perception: chance of spotting something, once again 0-1000
    */

    //TODO: implement tick
    public void tick(){}

    public double getTemperature(){return(this.animal.getTemperature());}
    public double getWeight(){return(this.weight);}
    public ArrayList<Liquid> getSoakedIn(){return(this.soakedIn);}
    public int getIntegrity(){return(this.integrity);}

    //TODO: implement inspection of body parts
    public String[] inspect(int perception){
        return(new String[] {});
    }

    /**
     * @return the coordinates of the animal to which this bodypart belongs.
     */
    public Coords getCoords(){return(this.animal.getCoords());}

}