public class Helper {

    public static int boolstoint(boolean[] bools){
        int total = 0;
        for(int i=0;i<bools.length;i++){
            if(bools[i]){total+=Math.pow(2,i);}
        }
        return(total);
    }

}
