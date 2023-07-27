import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] dp = new int[n];

        String[] inputArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }

        for (int i = 0; i < n; i++) {
            left[i] = 1;

            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i] && left[i] < left[j] + 1) {
                    left[i]++;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;

            for (int j = n-1; j > i; j--) {

                if (arr[j] < arr[i] && right[i] < right[j] + 1) {
                    right[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i] = left[i] + right[i];
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (result < dp[i]) {
                result = dp[i];
            }
        }

        System.out.println(result - 1);
    }
}