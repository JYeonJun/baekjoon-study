import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final List<FireBall> FIRE_BALLS = new LinkedList<>();
    private static final int[] DY = {-1, -1, 0, 1, 1, 1, 0, -1}, DX = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N, M, K;
    private static StringTokenizer st;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        matrix = new int[N + 1][N + 1];

        initFireBalls();

        simulate();

        // 파이어볼 질량의 합 계산
        int result = 0;
        for (FireBall fireBall : FIRE_BALLS) {
            result += fireBall.m;
        }

        System.out.println(result);
    }

    private static void simulate() {
        while (K-- > 0) {

            // 파이어볼 이동
            moveFireBalls();

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    int count = matrix[i][j];
                    if (count >= 2) { // 2개 이상의 파이어볼이 있는 칸
                        // 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
                        // 파이어볼은 4개의 파이어볼로 나누어진다.

                        int massSum = 0;
                        int speedSum = 0;
                        int oddCount = 0;
                        int evenCount = 0;
                        Iterator<FireBall> iterator = FIRE_BALLS.iterator();
                        while (iterator.hasNext()) {
                            FireBall fireBall = iterator.next();
                            if (fireBall.y == i && fireBall.x == j) {
                                massSum += fireBall.m;
                                speedSum += fireBall.s;

                                if ((fireBall.d & 1) == 1) {
                                    oddCount++;
                                } else {
                                    evenCount++;
                                }

                                iterator.remove();
                            }
                        }

                        // 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋
                        int mass = massSum / 5;
                        // 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋
                        int speed = speedSum / count;

                        // 만약 mass값이 0이 되면 소멸
                        if (mass == 0) {
                            matrix[i][j] = 0;
                            continue;
                        }

                        // 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
                        // 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수인 경우
                        if (oddCount == count || evenCount == count) {
                            FIRE_BALLS.add(new FireBall(i, j, mass, speed, 0));
                            FIRE_BALLS.add(new FireBall(i, j, mass, speed, 2));
                            FIRE_BALLS.add(new FireBall(i, j, mass, speed, 4));
                            FIRE_BALLS.add(new FireBall(i, j, mass, speed, 6));
                        } else {
                            FIRE_BALLS.add(new FireBall(i, j, mass, speed, 1));
                            FIRE_BALLS.add(new FireBall(i, j, mass, speed, 3));
                            FIRE_BALLS.add(new FireBall(i, j, mass, speed, 5));
                            FIRE_BALLS.add(new FireBall(i, j, mass, speed, 7));
                        }

                        // matrix[i][x] 값 갱신해야함
                        matrix[i][j] = 4;
                    }
                }
            }
        }
    }

    private static void moveFireBalls() {
        for (FireBall fireBall : FIRE_BALLS) {
            int cy = fireBall.y;
            int cx = fireBall.x;
            int dir = fireBall.d;
            int speed = fireBall.s;

            int ny = ((cy + DY[dir] * (speed % N)) - 1 + N) % N + 1;
            int nx = ((cx + DX[dir] * (speed % N)) - 1 + N) % N + 1;

            fireBall.changePos(ny, nx);
            matrix[cy][cx]--;
            matrix[ny][nx]++;
        }
    }

    private static void initFireBalls() throws IOException {
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            matrix[r][c]++;
            FIRE_BALLS.add(new FireBall(r, c, m, s, d));
        }
    }

    private static class FireBall {
        private int y, x, m, s, d;

        public FireBall(int y, int x, int m, int s, int d) {
            this.y = y;
            this.x = x;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public void changePos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}