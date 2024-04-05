import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main{
    public static void main(String[] args) throws IOException {
        // N : 사람의 수 (1 <= N <= 1000)
        // Pi : 각 사람이 돈을 인출하는데 걸리는 시간 (1 <= Pi <= 1000)
        // 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new TreeSet<>();

        int[] atm = new int[N];

        for(int i = 0; i < N; i++)
            atm[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(atm);

        int total = 0;
        int ind_time = 0;

        for(int i = 0; i < N; i++){
            ind_time += atm[i];
            total += ind_time;
        }

        System.out.println(total);
    }
}