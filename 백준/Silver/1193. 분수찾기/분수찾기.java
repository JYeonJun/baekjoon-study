import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		printFraction(X);
	}
	
	public static void printFraction(int X) {
		int count_sum = 0, count = 1;
		// count: 대각선 칸 개수
		// count_sum: 칸의 누적합
		
		if(X == 1) {
			System.out.println("1/1");
			return;
		}
		
		while(true) {
			if(X <= count_sum + count) {
				if(count % 2 == 1) {	// 대각선 칸 개수가 홀수라면
					System.out.println((count_sum + count - X + 1) + "/" + (X-count_sum));
					break;
				}
				else {	// 대각선 칸 개수가 짝수라면
					System.out.println(X-count_sum + "/" + (count_sum + count - X + 1));
					break;
				}
			}
			
			else {
				count_sum += count++;
			}
		}
	}
}