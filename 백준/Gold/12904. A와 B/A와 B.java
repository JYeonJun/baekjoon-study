import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        while (t.length() > s.length()) {
            int tLength = t.length() - 1;
            if (t.charAt(tLength) == 'A') {
                t.deleteCharAt(tLength);
            } else if (t.charAt(tLength) == 'B') {
                t.deleteCharAt(tLength);
                t.reverse();
            }
        }

        if (t.toString().equals(s.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}