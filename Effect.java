import java.util.*;

class Effect {

    String name;

    /**
     * the keywords this effect uses, such as infection/fracture/bone-related/whatever
     */
    ArrayList<String> keywords;

    int moveSpeed;
    int strength;
    int perception;
    int age;

    public Effect(String name, int moveSpeed, int strength, int perception, int age){
        this.name = name;
        this.keywords = new ArrayList<String>();
        this.moveSpeed = moveSpeed;
        this.strength = strength;
        this.perception = perception;
        this.age = age;
    }
}