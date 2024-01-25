import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int result = 0, index = 0;

        while (true) {
            result++;
            String s = String.valueOf(result);

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == input.charAt(index)) {
                    index++;
                }

                if (index == input.length()) {
                    System.out.println(result);
                    return;
                }
            }
        }
    }
}