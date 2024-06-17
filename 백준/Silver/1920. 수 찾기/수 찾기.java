import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            System.out.println(isIn(num));;
        }
    }

    private static int isIn(int num) {
        int start = 0, end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (num == A[mid]) {
                return 1;
            } else if (num < A[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}