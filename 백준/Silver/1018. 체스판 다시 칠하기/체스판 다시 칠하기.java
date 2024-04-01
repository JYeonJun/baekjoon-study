import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br;
    private static char[][] chessboard;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chessboard = new char[N][M];

        fillChessBoardColor();
        System.out.println(getMinColorChanged());
    }

    private static void fillChessBoardColor() throws IOException {
        for (int i = 0; i < N; i++) {
            chessboard[i] = br.readLine().toCharArray();
        }
    }

    private static int getMinColorChanged() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, countMinColorChanged(i, j));
            }
        }
        return min;
    }

    private static int countMinColorChanged(int y, int x) {
        int cntW = 0; // 첫 칸이 W일 경우
        int cntB = 0; // 첫 칸이 B일 경우
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if ((i + j) % 2 == 0) { // 원래 W여야 하는 위치
                    if (chessboard[i][j] != 'W') cntW++;
                    if (chessboard[i][j] != 'B') cntB++;
                } else { // 원래 B여야 하는 위치
                    if (chessboard[i][j] != 'B') cntW++;
                    if (chessboard[i][j] != 'W') cntB++;
                }
            }
        }
        return Math.min(cntW, cntB);
    }
}