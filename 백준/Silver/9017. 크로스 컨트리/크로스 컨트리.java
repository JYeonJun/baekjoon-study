import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] ranks = new int[N];
            Map<Integer, Integer> result = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int teamNum = Integer.parseInt(st.nextToken());
                result.put(teamNum, result.getOrDefault(teamNum, 0) + 1);
                ranks[i] = teamNum;
            }

            int[] fifthGoalIdx = new int[result.size() + 1];
            Map<Integer, Integer> scoreMap = new HashMap<>();
            Map<Integer, Integer> tmpMap = new HashMap<>();
            int score = 1;

            for (int teamNum : ranks) {
                if (result.get(teamNum) >= 6) {
                    tmpMap.put(teamNum, tmpMap.getOrDefault(teamNum, 0) + 1);

                    if (tmpMap.get(teamNum) <= 4) {
                        scoreMap.put(teamNum, scoreMap.getOrDefault(teamNum, 0) + score);
                    }

                    if (tmpMap.get(teamNum) == 5) {
                        fifthGoalIdx[teamNum] = score;
                    }
                    score++;
                }
            }

            List<Integer> end = new ArrayList<>(scoreMap.keySet());

            end.sort((x,y) -> {
                if (Integer.compare(scoreMap.get(x), scoreMap.get(y)) == 0) {
                    return fifthGoalIdx[x] - fifthGoalIdx[y];
                } else {
                    return scoreMap.get(x) - scoreMap.get(y);
                }
            });

            System.out.println(end.get(0));
        }

        br.close();
    }
}