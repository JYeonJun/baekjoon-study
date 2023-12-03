import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] charArray = s.toCharArray();
        int answer = 1, sIndex = 0, eIndex = s.length() - 1;

        for (int i = 0; i < s.length() / 2; i++) {
            if (charArray[sIndex++] != charArray[eIndex--]) {
                answer = 0;
                break;
            }
        }

        System.out.println(answer);
    }
}