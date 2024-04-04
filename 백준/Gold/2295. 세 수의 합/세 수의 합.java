import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Set<Integer> twoValuesSum = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                twoValuesSum.add(arr[i] + arr[j]);
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = N - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int twoValuesMinus = arr[i] - arr[j];
                if (twoValuesSum.contains(twoValuesMinus)) {
                    answer = Math.max(answer, arr[i]);
                }
            }
        }

        System.out.println(answer);
    }
}