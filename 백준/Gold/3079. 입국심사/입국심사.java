import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] timeTable = new long[n];
        for (int i = 0; i < n; i++) {
            timeTable[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(timeTable);
        long start = 1;
        long end = timeTable[0] * m;
        long answer = end;

        while (start <= end) {
           long mid = (start + end)/2;
           long cnt = 0;
            for (long time : timeTable) {
                cnt += (mid / time);
            }

            if (cnt >= m) {
                end = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
