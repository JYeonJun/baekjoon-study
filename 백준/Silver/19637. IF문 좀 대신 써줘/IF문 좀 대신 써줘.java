import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] badges = new String[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            badges[i][0] = st.nextToken();
            badges[i][1] = st.nextToken();
        }

        int left, right, mid;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            left = 0;
            right = N - 1;
            mid = (left + right) / 2;
            while (left <= right) {
                mid = (left + right) / 2;
                int com = Integer.parseInt(badges[mid][1]);
                if (num > com) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append(badges[left][0] + "\n");
        }

        System.out.println(sb);
    }
}