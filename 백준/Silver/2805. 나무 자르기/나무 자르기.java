import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];
        int start = 1, mid = 0, result = 0, end = Integer.MIN_VALUE;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            trees[i] = height;
            end = Math.max(end, height);
        }
        
        while (start <= end) {
            mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                int rest = trees[i] - mid;
                if (rest > 0) {
                    sum += rest;
                }
            }

            if (sum == M) {
                result = mid;
                break;
            }

            if (sum > M) {
                result = Math.max(result, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}