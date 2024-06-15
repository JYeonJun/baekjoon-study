import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[] temps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 온도를 측정한 전체 날짜의 수
        K = Integer.parseInt(st.nextToken()); // 합을 구하기 위한 연속적인 날짜의 수

        initTemps(br);

        int maxSum = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < K; i++) {
            sum += temps[i];
        }

        maxSum = Math.max(maxSum, sum);

        for (int i = K; i < N; i++) {
            sum -= temps[i - K];
            sum += temps[i];

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }

    private static void initTemps(BufferedReader br) throws IOException {
        temps = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temps[i] = Integer.parseInt(st.nextToken());
        }
    }
}