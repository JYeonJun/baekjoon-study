import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int L; // 암호 문자 수
    private static int C; // 문자 목록
    private static char[] alphaArr;
    private static char[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 암호 문자 수
        C = Integer.parseInt(st.nextToken()); // 문자 목록 수

        alphaArr = new char[C];
        result = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphaArr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphaArr);

        createEncryption(0, 0);
    }

    private static void createEncryption(int times, int index) {

        if (index == L) {
            if (isValid()) {
                System.out.println(result);
            }
            return;
        }

        for (int i = times; i < C; i++) {
            result[index] = alphaArr[i];
            createEncryption(i + 1, index + 1);
        }
    }

    private static boolean isValid() {

        int vowelCnt = 0; // 모음수
        int consonantCnt = 0; // 자음수

        for (char c : result) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCnt++;
            } else {
                consonantCnt++;
            }
        }

        if (vowelCnt >= 1 && consonantCnt >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
