import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
-----------------------------------------
1. 문제의 Input
T: 테스트케이스
N: 문서의 개수 (1 <= N <= 100)
M: 큐에서의 위치 (0 <= M < N)
문서의 중요도 (1 <= 중요도 <= 9)

2. 요구사항: 문서가 몇 번째로 출력되는지

3. 알고리즘
- FIFO로 빼고 중요도 확인 후 뒤에 다시 넣어야 하니 Deque
- M번째 숫자를 기억하기 위한 Node 클래스
- 더 높은 우선순위가 존재하는지 체크하기 위한 메서드

4. 제한시간: 2초 (시간은 충분할 듯)

5. 엣지케이스: 중요도가 같은 경우 조심!!
-----------------------------------------
 */

public class Main {

    private static int[] priorities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            Deque<Node> deque = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] docs = new int[N];
            priorities = new int[10];

            String str = br.readLine();
            st = new StringTokenizer(str);
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                docs[j] = num;
                priorities[num]++;

                if (j == M) {
                    deque.addLast(new Node(num, true));
                } else {
                    deque.addLast(new Node(num, false));
                }
            }

            int cnt = 0;
            while (!deque.isEmpty()) {
                Node node = deque.pollFirst();
                if (existBiggerNum(node.priority)) { // 더 큰 우선순위가 존재한다면 deque 뒤에 추가
                    deque.addLast(node);
                } else {
                    cnt++; // 문서가 실제로 인쇄될 때만 카운트 증가
                    priorities[node.priority]--; // 인쇄된 문서의 중요도 감소
                    if (node.isRight) {
                        System.out.println(cnt);
                        break;
                    }
                }
            }

        }
    }

    private static boolean existBiggerNum(int num) {
        for (int i = num + 1; i < 10; i++) {
            if (priorities[i] > 0) {
                return true;
            }
        }
        return false;
    }

    private static class Node {
        private int priority;
        private boolean isRight;

        public Node(int priority, boolean isRight) {
            this.priority = priority;
            this.isRight = isRight;
        }
    }
}