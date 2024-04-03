import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/*
-----------------------------------------
1. 문제의 Input
- N: 탑의 수 (1 <= N <= 500,000)
- 탑들의 높이 (1 <= 높이 <= 100,000,000)

2. 요구사항: 레이저 신호를 어느 탑에서 수신하는지

3. 알고리즘
- 2중 포문 해가지고 마지막 인덱스부터 첫번째 인덱스 순으로 수행해서 현재 인덱스 탑 높이보다 큰 탑 있으면 해당 인덱스 + 1 StringBuilder에 추가하기
- 1부터 100,000,000 까지 배열 만들고

4. 제한시간: 1.5초
- N의 최대 크기는 500,000 -> 500,000 ^ 2 = 250,000,000,000 = 25초 => 시간 초과 (이중 반복문 X)

5. 엣지케이스
-----------------------------------------
 */

public class Main {

    public static void main(String[] args) throws IOException {
        Stack<Top> stack = new Stack<>();
        List<Top> list = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            Top current = new Top(i, Integer.parseInt(st.nextToken()));

            if (stack.isEmpty()) {
                result.append("0 ");
                stack.push(current);
                continue;
            }

            while (!stack.isEmpty()) {
                Top peek = stack.peek();
                if (peek.height < current.height) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        result.append("0 ");
                        break;
                    }
                } else { // 높이가 같거나 크다면
                    // 결과에 추가하고
                    result.append(peek.num + " ");
                    break;
                }
            }

            stack.push(current);
        }

        System.out.println(result);
    }

    private static class Top {
        private int num, height;

        public Top(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }
}