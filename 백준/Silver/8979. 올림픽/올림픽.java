import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<State> pq = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int num, gold, silver, bronze;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            num = Integer.parseInt(st.nextToken());
            gold = Integer.parseInt(st.nextToken());
            silver = Integer.parseInt(st.nextToken());
            bronze = Integer.parseInt(st.nextToken());

            pq.add(new State(num, gold, silver, bronze));
        }

        int rank = 1;
        boolean eq = false;
        while (!pq.isEmpty()) {
            State now = pq.poll();
            if (now.num == K) {
                System.out.println(rank);
                break;
            }

            if (!eq && now.eq) {
                eq = true;
            }

            if (eq && now.eq) {
                continue;
            }

            if (eq && !now.eq) {
                eq = false;
            }
            rank++;
        }
    }

    private static class State implements Comparable<State>{
        private int num, gold, silver, bronze;
        private boolean eq;

        public State(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.eq = false;
        }

        @Override
        public int compareTo(State o) {
            if (this.gold != o.gold) {
                return o.gold - this.gold;
            }
            if (this.silver != o.silver) {
                return o.silver - this.silver;
            }
            if (this.bronze != o.bronze) {
                return o.bronze - this.bronze;
            }

            this.eq = true;
            return 0;
        }
    }
}