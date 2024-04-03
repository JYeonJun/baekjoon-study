import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

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

        for (int i = 0; i < N; i++) {
            // 스택이 비어있지 않고, 현재 수열의 수가 스택의 top에 있는 인덱스의 수보다 클 때
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                // 오큰수를 ans 배열에 저장
                ans[stack.pop()] = nums[i];
            }
            // 인덱스를 스택에 저장
            stack.push(i);
        }

        // 스택에 남아 있는 인덱스에 대해 오큰수가 없으므로 -1을 저장
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
