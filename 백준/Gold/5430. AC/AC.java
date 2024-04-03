import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/*
---------------------------------------------------
1. 문제의 Input
- T: 테스트 케이스 개수 (1 <= T <= 100)
- p: 수행할 함수 (1 <= p.length <= 100,000)
- n: 배열에 들어있는 수의 개수 (0 <= n <= 100,000)
- 배열에 들어있는 정수 (1 <= xi <= 100) - int 사용 가능

- 전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.

2. 요구사항
- R: 배열에 있는 수의 순서를 뒤집는 함수
- D: 첫 번째 수를 버리는 함수
-> 배열이 비어있는데 D를 사용한 경우 에러 발생

3. 알고리즘

4. 제한시간: 1초
-> 수행할 함수 * 배열에 들어있는 수의 개수 > 1억 => 시간 초과

5. 엣지케이스
 ---------------------------------------------------
 */

public class Main {

    private static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            deque = new LinkedList<>();
            boolean tmp = true; // true면 앞에서, false면 뒤에서
            boolean isError = false;
            String p = br.readLine();

            int n = Integer.parseInt(br.readLine());

            String numStr = br.readLine().replace("[", "")
                    .replace("]", "");

            String[] split = numStr.split(",");
            for (String s : split) {
                if (!s.isEmpty()) {
                    deque.addLast(Integer.valueOf(s));
                }
            }

            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    tmp = !tmp;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (tmp) { // 앞에서 제거
                        deque.pollFirst();
                    } else { // 뒤에서 제거
                        deque.pollLast();
                    }
                }
            }

            if (isError) {
                System.out.println("error");
                continue;
            }
            StringBuilder result = new StringBuilder();
            result.append("[");

            while (!deque.isEmpty()) {
                if (tmp) { // 앞에서부터 출력
                    result.append(deque.pollFirst() + ",");
                } else {
                    result.append(deque.pollLast() + ",");
                }
            }
            if (result.length() > 1) {
                result.deleteCharAt(result.length() - 1);
            }
            result.append("]");
            System.out.println(result);
        }
    }
}