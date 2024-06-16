import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int answer = 0;
        for (int k = 0; k < N; k++) {
            int target = nums[k];
            int i = 0;
            int j = N - 1;

            while (i < j) {
                int sum = nums[i] + nums[j];

                if (sum == target) {
                    if (i != k && j != k) {
                        answer++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        System.out.println(answer);
    }
}