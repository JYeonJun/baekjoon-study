import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static boolean[][] map;
    private static int result, I;
    private static Pos nPos, dPos;;
    private static final int[] nextY = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int[] nextX = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            result = Integer.MAX_VALUE;
            I = Integer.parseInt(br.readLine());
            map = new boolean[I][I];
            st = new StringTokenizer(br.readLine());
            nPos = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            dPos = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            bfs(nPos);
            System.out.println(result);
        }
    }

    private static void bfs(Pos nPos) {
        Queue<Pos> que = new LinkedList<>();
        map[nPos.y][nPos.x] = true;
        que.add(nPos);

        int dy = dPos.y;
        int dx = dPos.x;

        while(!que.isEmpty()){
            Pos pos = que.poll();
            int y = pos.y;
            int x = pos.x;
            if (y == dy && x == dx) {
                compare(pos.cnt);
                continue;
            }
            int tmpY, tmpX;
            for (int i = 0; i < nextY.length; i++) {
                tmpY = y + nextY[i];
                tmpX = x + nextX[i];

                if (tmpY < 0 || tmpY >= I || tmpX < 0 || tmpX >= I || map[tmpY][tmpX]) {
                    continue;
                }

                map[tmpY][tmpX] = true;
                que.add(new Pos(tmpY, tmpX, pos.cnt + 1));
            }
        }
    }

    private static void compare(int num) {
        result = Math.min(result, num);
    }

    private static class Pos {
        private int x, y, cnt;

        public Pos(int y, int x, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}