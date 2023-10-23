import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, result;
    private static int[] budgetArr;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        budgetArr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            budgetArr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        Arrays.sort(budgetArr);

        int max = budgetArr[N - 1];

        biSearch(1, max);
        System.out.println(result);
    }

    private static int calculateSum(int mid) {

        int sum = 0;

        for (int i : budgetArr) {

            if (i > mid) {
                sum += mid;
            } else {
                sum += i;
            }
        }

        return sum;
    }

    private static void biSearch(int start, int end) {

        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;
        int sum = calculateSum(mid);

        if (sum <= M) {
            result = mid;

            biSearch(mid + 1, end);
        } else {
            biSearch(1, mid - 1);
        }
    }
}