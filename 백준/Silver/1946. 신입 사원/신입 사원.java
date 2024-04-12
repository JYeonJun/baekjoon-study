import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N + 1];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                int documentRank = Integer.parseInt(st.nextToken());
                int interviewRank = Integer.parseInt(st.nextToken());

                rank[documentRank] = interviewRank;
            }

            int answer = 1;
            int standard = rank[1];

            for (int j = 2; j <= N; j++) {
                if (rank[j] < standard) {
                    answer++;
                    standard = rank[j];
                }
            }

            System.out.println(answer);
        }
    }
}