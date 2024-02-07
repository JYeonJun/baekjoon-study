import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Nation[] nations = new Nation[N];
        Nation targetNation = new Nation();

        int num, gold, silver, bronze;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            num = Integer.parseInt(st.nextToken());
            gold = Integer.parseInt(st.nextToken());
            silver = Integer.parseInt(st.nextToken());
            bronze = Integer.parseInt(st.nextToken());

            nations[i] = new Nation(num, gold, silver, bronze);
            if (num == K) targetNation = nations[i];
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {

            if (nations[i].num == K) {
                continue;
            } else {
                if (targetNation.gold < nations[i].gold) {
                    rank++;
                }

                if ((targetNation.gold == nations[i].gold) && (targetNation.silver < nations[i].silver)) {
                    rank++;
                }

                if ((targetNation.gold == nations[i].gold) && (targetNation.silver == nations[i].silver) && (
                        targetNation.bronze < nations[i].bronze)) {

                    rank++;
                }
            }
        }

        System.out.println(rank);

        br.close();
    }

    private static class Nation implements Comparable<Nation> {
        private int num, gold, silver, bronze;

        public Nation() {
        }

        public Nation(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.gold != o.gold) {
                return o.gold - this.gold;
            }
            if (this.silver != o.silver) {
                return o.silver - this.silver;
            }
            if (this.bronze != o.bronze) {
                return o.bronze - this.bronze;
            }
            return 0;
        }
    }
}