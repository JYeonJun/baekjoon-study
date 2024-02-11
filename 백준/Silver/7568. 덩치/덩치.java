import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] humanBuildList = new int[N][2];
		
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			humanBuildList[i][0] = Integer.parseInt(st.nextToken());
			humanBuildList[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			int ranking = 1;
			for(int j = 0; j < N; j++) {
				if(i == j)
					continue;
				
				if(humanBuildList[i][0] < humanBuildList[j][0] && humanBuildList[i][1] < humanBuildList[j][1])
					ranking++;
			}
			System.out.print(ranking + " ");
		}
	}
}