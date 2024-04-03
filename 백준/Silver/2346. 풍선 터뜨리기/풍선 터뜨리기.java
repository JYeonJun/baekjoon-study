import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
-----------------------------------------
1. 문제의 Input
- N: 풍선의 개수 (1 <= N <= 1,000)
- 각 풍선 안 종이에 적혀 있는 숫자 리스트

2. 요구사항: 터진 풍선의 번호 나열

3. 알고리즘
- 숫자 + 이동 % (N + 1) = 이동하는 개수
-> N은 작아져야 한다.

4. 제한시간: 2초 (시간은 충분할 듯)

5. 엣지케이스
-----------------------------------------
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Node> balloons = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            balloons.add(new Node(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder result = new StringBuilder();
        int index = 0; // 현재 위치
        while (!balloons.isEmpty()) {
            Node current = balloons.remove(index); // 현재 풍선을 제거하고, 이동할 풍선 정보를 가져옴
            result.append(current.num + " ");

            if (balloons.isEmpty()) { // 모든 풍선이 제거되었으면 반복 종료
                break;
            }

            // 이동 횟수 계산
            int moveCnt = current.moveCnt;
            int balloonSize = balloons.size();
            if (moveCnt > 0) {
                index = (index + moveCnt - 1) % balloonSize; // 양수인 경우
            } else {
                index = (index + moveCnt) % balloonSize; // 음수인 경우
                if (index < 0) {
                    index += balloonSize;
                }
            }
        }

        System.out.println(result);
    }

    private static class Node {
        private int num, moveCnt;

        public Node(int num, int moveCnt) {
            this.num = num;
            this.moveCnt = moveCnt;
        }
    }
}