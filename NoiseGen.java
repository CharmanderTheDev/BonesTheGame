import java.util.Random;

public class NoiseGen {
    
    public static int[][] getNoise(int n){
        int[][] noise = new int[n][n];
        for(int i=0;i<n;i++){for(int j=0;j<n;j++){noise[i][j]=8;}}
        Random random = new Random();

        for(int i=0;i<n;i++){for(int j=0;j<n;j++){
            int totaladj = 0;
            try{totaladj+=noise[i-1][j];}catch(Exception e){}
            try{totaladj+=noise[i+1][j];}catch(Exception e){}
            try{totaladj+=noise[i][j-1];}catch(Exception e){}
            try{totaladj+=noise[i][j+1];}catch(Exception e){}
            noise[i][j] = (totaladj + (random.nextInt(16)-8)) / 4;
        }}

        return(noise);
    }
}
