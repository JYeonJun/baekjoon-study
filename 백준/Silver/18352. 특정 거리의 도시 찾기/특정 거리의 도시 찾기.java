import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static ArrayList<Integer>[] road;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        visited = new boolean[N + 1];
        road = new ArrayList[N + 1];
        for (int i = 0; i < road.length; i++) {
            road[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            road[start].add(dest); // 단방향 도로
        }

        List<Integer> result = bfs(X, K);
        if (result.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            
            for (Integer city : result) {
                System.out.println(city);
            }
        }
    }

    public static List<Integer> bfs(int start, int K) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start, 0));
        visited[start] = true;

        List<Integer> result = new ArrayList<>();

        while (que.size() != 0) {
            Node city = que.poll();
            int cityNum = city.getCityNum();
            int cnt = city.getCnt();

            if (cnt == K) {
                result.add(city.getCityNum());
                continue;
            }
            for (int i = 0; i < road[cityNum].size(); i++) {
                if (!visited[road[cityNum].get(i)]) {
                    que.add(new Node(road[cityNum].get(i), cnt + 1));
                    visited[road[cityNum].get(i)] = true;
                }
            }
        }

        return result;
    }

    private static class Node {
        private int cityNum;
        private int cnt;

        public Node(int cityNum, int cnt) {
            this.cityNum = cityNum;
            this.cnt = cnt;
        }

        public int getCityNum() {
            return cityNum;
        }

        public int getCnt() {
            return cnt;
        }
    }
}