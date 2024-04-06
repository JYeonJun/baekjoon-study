import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    private static int N;
    private static int[] nums;
    private static final Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);
        System.out.println(one(sum));
        System.out.println(two());
        System.out.println(three());
        System.out.println(four());
    }

    private static int one(int sum) {
        return (int)Math.round((double)sum / N);
    }

    private static int two() {
        return nums[N / 2];
    }

    private static int three() {
        int maxCount = Integer.MIN_VALUE;
        for (int frequency : map.values()) {
            maxCount = Math.max(maxCount, frequency);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (var e : map.entrySet()) {
            if (e.getValue() == maxCount) {
                pq.add(e.getKey());
            }
        }

        if (pq.size() == 1) {
            return pq.peek();
        } else {
            pq.poll();
            return pq.peek();
        }
    }

    private static int four() {
        return nums[N - 1] - nums[0];
    }
}
