import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
-----------------------------------------
1. 문제의 Input
- N: 연산의 개수 (1 <= N <= 100,000)
- x: 연산에 대한 정보 (-2^31 < x < 2^31) - int형 가능
-> x != 0: 배열에 x 삽입
-> x == 0: 배열에서 절댓값이 가장 작은 값 출력

2. 요구사항: 0이 주어진 횟수만큼 답 출력

3. 알고리즘
- PriorityQueue<Integer> 사용
-> 정렬조건: 절댓값이 같다면 숫자 오름차순, 다르다면 절댓값 오름차순

4. 제한시간: 2초

5. 엣지케이스
- 배열이 비어있는 경우 0 출력!!
-----------------------------------------
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            int abs1 = Math.abs(n1);
            int abs2 = Math.abs(n2);

            if (abs1 == abs2) {
                return n1 - n2;
            }
            return abs1 - abs2;
        });

        int x;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(x);
            } else {
                if (pq.isEmpty()) {
                    result.append("0").append("\n");
                    continue;
                }
                result.append(pq.poll()).append("\n");
            }
        }

        System.out.println(result);
    }
}