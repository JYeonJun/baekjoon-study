import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

    private static int r, c, k, rowLen, colLen;
    private static int[][] A;
    private static final int INIT_LEN = 3;
    private static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[101][101];
        rowLen = INIT_LEN;
        colLen = INIT_LEN;

        for (int i = 0; i < rowLen; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colLen; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = -1;
        int timeCount = 0;
        while (timeCount <= 100) {
            if (A[r - 1][c - 1] == k) {
                result = timeCount;
                break;
            }

            if (rowLen >= colLen) {
                rCal();
            } else {
                cCal();
            }

            timeCount++;
        }

        System.out.println(result);
    }

    private static void rCal() {
        int[][] copy = new int[101][101];
        int col = 0;
        List<Node> list;
        for (int i = 0; i < rowLen; i++) {
            map = new HashMap<>();
            for (int j = 0; j < colLen; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                map.put(A[i][j], map.getOrDefault(A[i][j], 0) + 1);
            }
            list = new ArrayList<>();
            for (Entry<Integer, Integer> e : map.entrySet()) {
                list.add(new Node(e.getKey(), e.getValue()));
            }
            col = Math.max(col, list.size()*2);
            Collections.sort(list);
            for (int k = 0; k < list.size(); k++) {
                if (k >= 50) break;
                Node node = list.get(k);
                copy[i][2 * k] = node.num;
                copy[i][2 * k + 1] = node.cnt;
            }
        }
        colLen = col;
        A = copy;
    }

    private static void cCal() {
        int[][] copy = new int[101][101];
        int row = 0;
        List<Node> list;
        for (int i = 0; i < colLen; i++) {
            map = new HashMap<>();
            for (int j = 0; j < rowLen; j++) {
                if (A[j][i] == 0) {
                    continue;
                }
                map.put(A[j][i], map.getOrDefault(A[j][i], 0) + 1);
            }
            list = new ArrayList<>();
            for (Entry<Integer, Integer> e : map.entrySet()) {
                list.add(new Node(e.getKey(), e.getValue()));
            }
            row = Math.max(row, list.size()*2);
            Collections.sort(list);
            for (int k = 0; k < list.size(); k++) {
                if (k >= 50) break;
                Node node = list.get(k);
                copy[2 * k][i] = node.num;
                copy[2 * k + 1][i] = node.cnt;
            }
        }
        rowLen = row;
        A = copy;
    }

    private static class Node implements Comparable<Node>{
        int num, cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node node) {
            if (this.cnt == node.cnt) {
                return this.num - node.num;
            }
            return this.cnt - node.cnt;
        }
    }
}