import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1. 문제의 Input
// 대문자와 소문자로 구성된 단어 (길이는 1_000_000을 넘지 않는다.)
// 대소문자를 구분하지 않는다.

// 2. 요구사항
// 단어에서 가장 많이 사용된 알파벳을 `대문자`로 출력한다!!

// 3. 알고리즘
// 구현
// 1) 문자열의 각 단어를 검사 -> map에 해당 문자의 소문자, 대문자가 들어있는지 검사하고 있다면 ++
// 2) int 배열 생성 -> 문자열의 각 단어를 대문자로 치환 -> 각 문자 - 65('A') 인덱스에다가 ++ -> 제일 큰 수를 출력

// 4. 제한시간
// 2초 -> 2중 방복문은 사용하면 안된다!!

// 5. 엣지 포인트
// int 오버플로우
// 가장 많이 사용된 알파벳이 여럿인 경우 '?' 출력

public class Main {

    private static final int ALPHA_CNT = 26;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] cnt = new int[ALPHA_CNT];
        char result = 'A';
        
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            char upperCase = Character.toUpperCase(ch);
            int u = upperCase;
            cnt[u - 65]++;
        }

        int max = Integer.MIN_VALUE, resultCnt = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > max) {
                result = (char)(i + 65);
                max = cnt[i];
            }
        }

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) {
                resultCnt++;
            }
        }

        if (resultCnt > 1) {
            System.out.println("?");
        } else {
            System.out.println(result);
        }
    }
}
