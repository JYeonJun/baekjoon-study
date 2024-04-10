import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] matrix;
    private static int N, answer;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        answer = Integer.MAX_VALUE;
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, N / 2);
        System.out.println(answer);
    }

    private static void combination(int start, int r) {
        if (r == 0) {
            answer = Math.min(answer, calculate());
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(i + 1, r - 1);
            visited[i] = false;
        }
    }

    private static int calculate() {

        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += matrix[i][j];
                    startTeam += matrix[j][i];
                }

                if (!visited[i] && !visited[j]) {
                    linkTeam += matrix[i][j];
                    linkTeam += matrix[j][i];
                }
            }
        }

        return Math.abs(startTeam - linkTeam);
    }
}