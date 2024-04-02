import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static List<Pos> chickens = new ArrayList<>();
    private static List<String> chickenComb = new ArrayList<>();
    private static List<Pos> homes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    homes.add(new Pos(i, j));
                }
                if (num == 2) {
                    chickens.add(new Pos(i, j));
                }
            }
        }
        createComb(0, 0, "");
        System.out.println(solution());
    }

    private static int solution() {
        StringTokenizer st;
        int min = Integer.MAX_VALUE;
        for (String com : chickenComb) {
            st = new StringTokenizer(com);
            int sum = 0;
            for (Pos homePos : homes) {
                int minDist = Integer.MAX_VALUE;
                while (st.hasMoreTokens()) {
                    int index = Integer.parseInt(st.nextToken());
                    Pos chickenPos = chickens.get(index);
                    int dist = Math.abs(chickenPos.y - homePos.y) + Math.abs(chickenPos.x - homePos.x);
                    minDist = Math.min(minDist, dist);
                }
                sum += minDist;
                st = new StringTokenizer(com);
            }
            min = Math.min(min, sum);
        }
        return min;
    }


    private static void createComb(int start, int depth, String result) {
        if (depth == M) {
            chickenComb.add(result.trim());
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            createComb(i + 1, depth + 1, result + i + " ");
        }
    }

    private static class Pos {
        private int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
