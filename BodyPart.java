import java.util.*;

class BodyPart implements Solid{
    
    public String name;
    private int moveSpeed;
    private int strength;
    private int perception;

    private ArrayList<Effect> effects;
    private int temperature;
    private int weight;
    private int integrity;
    private ArrayList<Liquid> soakedIn;


    public BodyPart(String name, int moveSpeed, int strength, int perception){
        this.name = name;
        this.moveSpeed = moveSpeed;
        this.strength = strength;
        this.perception = perception;
        this.effects = new ArrayList<Effect>();
    }
    
    public void effect(Effect effect){
        this.effects.add(effect);
    }

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
    public void tick(ArrayList<ArrayList<Part>> world){}

    public int getTemperature(){return(this.temperature);}
    public int getWeight(){return(this.weight);}
    public ArrayList<Liquid> getSoakedIn(){return(this.soakedIn);}
    public int getIntegrity(){return(this.integrity);}

    //TODO: implement inspection of body parts
    public String inspect(int perception, int range){
        return("");
    }

}