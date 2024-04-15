import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder S, T;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = new StringBuilder(br.readLine());
        T = new StringBuilder(br.readLine());

        dfs(T.length());
        System.out.println(result);
    }

    private static void dfs(int depth) {
        if (depth == S.length()) {
            if (T.compareTo(S) == 0) {
                result = 1;
            }
            return;
        }

        if (T.charAt(T.length() - 1) == 'A') {
            // 1번 연산 ㄱㄱ
            removeLastA();
            // dfs
            dfs(depth - 1);
            // 1번 연산 해제
            addA();
        }
        if (T.charAt(0) == 'B') {
            // 2번 연산 ㄱㄱ
            removeBAndReverse();
            // dfs
            dfs(depth - 1);
            // 2번 연산 해제
            addBAndReverse();
        }
    }

    private static void addA() {
        T.append("A");
    }

    private static void removeLastA() {
        T.deleteCharAt(T.length() - 1);
    }

    private static void addBAndReverse() {
        T.append("B");
        T.reverse();
    }

    private static void removeBAndReverse() {
        T.reverse();
        T.deleteCharAt(T.length() - 1);
    }
}