import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static char[][] room;
    private static int N;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        room = new char[N][N];
        fillRoom();

        int rowResult = 0, columnResult = 0;
        for (int i = 0; i < N; i++) {
            int rowDotCnt = 0;
            for (int j = 0; j <= N; j++) {
                if (j < N && room[i][j] == '.') {
                    rowDotCnt++;
                } else {
                    if (rowDotCnt > 1) {
                        rowResult++;
                    }
                    rowDotCnt = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int columnDotCnt = 0;
            for (int j = 0; j <= N; j++) {
                if (j < N && room[j][i] == '.') {
                    columnDotCnt++;
                } else {
                    if (columnDotCnt > 1) {
                        columnResult++;
                    }
                    columnDotCnt = 0;
                }
            }
        }

        System.out.println(rowResult + " " + columnResult);
    }

    private static void fillRoom() throws IOException {
        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                room[i][j] = charArray[j];
            }
        }
    }
}