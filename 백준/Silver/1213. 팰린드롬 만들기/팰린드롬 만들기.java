import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String englishName = br.readLine();

        int[] alpha = new int[26];

        for (int i = 0; i < englishName.length(); i++) {
            alpha[englishName.charAt(i)-65]++;
        }

        int check = 0;
        for (int i : alpha) {
            if (i % 2 != 0) {
                check++;
            }
        }

        if (check > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        String result = "";
        for (int i = 0; i < alpha.length; i++) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char) (i + 65));
            }
        }

        result += sb.toString();

        String end = sb.reverse().toString();

        sb = new StringBuilder();
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 != 0) {
                sb.append((char) (i + 65));
            }
        }

        result += sb.toString() + end;

        System.out.println(result);
    }
}