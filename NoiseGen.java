import java.util.Random;

public class NoiseGen {
    //IMPORTANT NOTE: SETTING THE MINIMUM TO INTEGER.MAX_VALUE WILL REMOVE MINIMUMS,
    //AND VICE VERSA.
    public static int[][] getNoise(int n, int base, int variation, int min, int max){
        int[][] noise = new int[n][n];
        for(int i=0;i<n;i++){for(int j=0;j<n;j++){noise[i][j]=base;}}
        Random random = new Random();

        //Randomizing
        for(int i=0;i<n;i++){for(int j=0;j<n;j++){
            int totaladj = 0;
            try{totaladj+=noise[i-1][j];}catch(Exception e){}
            try{totaladj+=noise[i+1][j];}catch(Exception e){}
            try{totaladj+=noise[i][j-1];}catch(Exception e){}
            try{totaladj+=noise[i][j+1];}catch(Exception e){}
            noise[i][j] = (totaladj + (random.nextInt(variation*2)-variation)) / 4;
            if(min!=Integer.MAX_VALUE&&(noise)[i][j]<min){noise[i][j]=min;}
            if(max!=Integer.MIN_VALUE&&(noise)[i][j]>max){noise[i][j]=max;}
        }}

        //Smoothing out
        for(int i=0;i<n;i++){for(int j=0;j<n;j++){
            int totaladj = 0;
            try{totaladj+=noise[i-1][j];}catch(Exception e){}
            try{totaladj+=noise[i+1][j];}catch(Exception e){}
            try{totaladj+=noise[i][j-1];}catch(Exception e){}
            try{totaladj+=noise[i][j+1];}catch(Exception e){}
            noise[i][j] = (totaladj / 4);
            if(min!=Integer.MAX_VALUE&&(noise)[i][j]<min){noise[i][j]=min;}
            if(max!=Integer.MIN_VALUE&&(noise)[i][j]>max){noise[i][j]=max;}
        }}

        return(noise);
    }
}
