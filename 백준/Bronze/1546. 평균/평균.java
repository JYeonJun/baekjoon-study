import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] score = new double[Integer.parseInt(br.readLine())];
        double M;	// 최고 점수
        double sum = 0;
        String str_score = br.readLine();
        StringTokenizer st = new StringTokenizer(str_score);
        
        for(int i = 0; i < score.length; i++)
        	score[i] = Integer.parseInt(st.nextToken());
        
        M = score[0];
        
        for(int i = 0; i < score.length; i++)
        	if(M < score[i]) 
        		M = score[i];

        for(int i = 0; i < score.length; i++)
        	score[i] = score[i]/M*100;

        for(double value: score)
        	sum += value;
        
        System.out.println(sum/score.length); 
    }
}