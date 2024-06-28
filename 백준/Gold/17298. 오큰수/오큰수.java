import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
---------------------------------------------------
1. 문제의 Input
- N: 수열 A의 크기 (1 <= N <= 1,000,000)
- 수열 A의 원소 (1 <= 먀 <= 1,000,000) - int 사용 가능

2. 요구사항: 총 N개의 오큰 수 출력

3. 알고리즘
- 스택
- 수를 저장하는 배열, 결과를 저장하는 배열
- 스택에 있는 값과 현재값 비교하면서, 루프 돌기

4. 제한시간: 1초
- N ^ 2 > 1초 => 2중 반복문 X

5. 엣지케이스
 ---------------------------------------------------
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[N]; // 원소를 저장할 배열
        int[] ans = new int[N]; // 오큰수를 저장할 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                ans[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(' ');
        }

        System.out.println(sb.toString().trim());
    }
}
