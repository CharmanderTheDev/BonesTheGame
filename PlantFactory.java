public class PlantFactory {
    
    public static Plant getPlant(String type, int age, double temperature, Coords coords){
        if(type.equals("Creep")){
            return(new Creep(age, temperature, coords));
        }

        else{return(null);}
    }
}
