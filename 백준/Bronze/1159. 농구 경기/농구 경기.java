import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphaCnt = new int[26];
        int answerCnt = 0;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char c = s.charAt(0);
            alphaCnt[c - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            int aCnt = alphaCnt[i];

            if (aCnt >= 5) {
                answerCnt++;
                System.out.print((char)(i + 97));
            }
        }

        if (answerCnt == 0) {
            System.out.println("PREDAJA");
        }
    }
}