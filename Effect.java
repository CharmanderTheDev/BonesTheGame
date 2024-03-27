import java.util.*;

abstract class Effect {

    String name;
    ArrayList<String> keywords;
    int moveSpeed;
    int strength;
    int perception;

    public Effect(String name, int moveSpeed, int strength, int perception){
        this.name = name;
        this.moveSpeed = moveSpeed;
        this.strength = strength;
        this.perception = perception;
    }
}