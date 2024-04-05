import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> set = new TreeSet<>();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            set.add(num);
        }

        int[] setArr = set.stream().mapToInt(Integer::intValue).toArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int targetNum = arr[i];

            int start = 0;
            int end = setArr.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;

                int setNum = setArr[mid];
                if (setNum == targetNum) {
                    sb.append(mid).append(" ");
                    break;
                }

                if (setNum < targetNum) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        System.out.println(sb);
    }
}