import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder S, T;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        S = new StringBuilder(reader.readLine());
        T = new StringBuilder(reader.readLine());

        // 변환 가능성 판별 - 목표 문자열의 길이를 시작 깊이로 전달
        transform(T.length());
        System.out.println(result);
    }

    // 재귀
    private static void transform(int depth) {
        if (depth == S.length()) { // 만약 T 문자열의 길이가 S 문자열의 길이와 같다면, 두 문자열을 비교
            if (T.toString().equals(S.toString())) {
                result = 1;
            }
            return;
        }

        // T 마지막 문자가 'A'라면, 제거하고 재귀 호출
        if (T.charAt(T.length() - 1) == 'A') {
            removeLastChar();
            transform(depth - 1);
            undoRemoveLastChar('A'); // 재귀 호출 후, 제거했던 'A' 추가
        }
        // T 첫 문자가 'B'라면, 문자열을 뒤집고 마지막 문자를 제거한 후 재귀 호출
        if (T.charAt(0) == 'B') {
            reverseAndRemoveLastChar();
            transform(depth - 1);
            undoReverseAndRemoveLastChar('B'); // 재귀 호출 후, 원상복구
        }
    }

    // T의 마지막 문자를 제거
    private static void removeLastChar() {
        T.deleteCharAt(T.length() - 1);
    }

    // 제거했던 마지막 문자 복구
    private static void undoRemoveLastChar(char charToAdd) {
        T.append(charToAdd);
    }

    // T를 뒤집고 마지막 문자 제거
    private static void reverseAndRemoveLastChar() {
        T.reverse();
        removeLastChar();
    }

    // reverseAndRemoveLastChar 메소드에 의해 변경된 상태를 원상 복구
    private static void undoReverseAndRemoveLastChar(char charToAdd) {
        undoRemoveLastChar(charToAdd);
        T.reverse();
    }
}