import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] visited, relation;

    private static final int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        visited = new int[n + 1][n + 1];
        relation = new int[n * n + 1][4];

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 4; j++) {
                relation[student][j] = Integer.parseInt(st.nextToken());
            }

            simulate(student);
        }

        calculateScore();
    }

    private static void calculateScore() {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int student = visited[i][j];
                int likeCount = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }

                    for (int l = 0; l < 4; l++) {
                        if (visited[nx][ny] == relation[student][l]) {
                            likeCount++;
                        }
                    }
                }

                answer += Math.pow(10, likeCount - 1);
            }
        }

        System.out.println(answer);
    }

    private static void simulate(int student) {
        int maxEmptyCount = 0;
        int maxLikeCount = 0;
        int x = 0, y = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (visited[i][j] != 0) {
                    continue;
                }

                int likeCount = 0, emptyCount = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }

                    if (visited[nx][ny] == 0) {
                        emptyCount++;
                    } else {
                        for (int l = 0; l < 4; l++) {
                            if (visited[nx][ny] == relation[student][l]) {
                                likeCount++;
                            }
                        }
                    }
                }

                if (likeCount > maxLikeCount || (likeCount == maxLikeCount && maxEmptyCount <= emptyCount)) {
                    maxLikeCount = likeCount;
                    maxEmptyCount = emptyCount;
                    x = i;
                    y = j;
                }
            }
        }

        visited[x][y] = student;
    }
}