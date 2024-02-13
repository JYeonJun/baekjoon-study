import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BigInteger[] arr = new BigInteger[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = new BigInteger(st.nextToken());
        }

        Arrays.sort(arr);

        int j;
        BigInteger tmp, result = new BigInteger("-1");
        if ((N & 1) == 1) { // 홀수인 경우
            j = N - 2;
            for (int i = 0; i < N / 2; i++) {

                tmp = arr[i].add(arr[j--]);
                result = result.compareTo(tmp) == 1 ? result : tmp;
            }
            result = result.compareTo(arr[N - 1]) == 1 ? result : arr[N - 1];
        } else { // 짝수인 경우
            j = N - 1;
            for (int i = 0; i < N / 2; i++) {

                tmp = arr[i].add(arr[j--]);
                result = result.compareTo(tmp) == 1 ? result : tmp;
            }
        }

        System.out.println(result);
    }
}