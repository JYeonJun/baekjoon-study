import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] L = new int[N];
        int[] R = new int[N];

        String[] inputLine = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputLine[i]);
        }

        L[0] = arr[0];
        int result = L[0];
        for (int i = 1; i < N; i++) {
            L[i] = Math.max(arr[i], L[i - 1] + arr[i]);
            result = Math.max(result, L[i]);
        }

        R[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            R[i] = Math.max(arr[i], R[i + 1] + arr[i]);
        }
        
        for (int i = 1; i < N - 1; i++) {
            result = Math.max(result, L[i - 1] + R[i + 1]);
        }

        System.out.println(result);
    }
}
