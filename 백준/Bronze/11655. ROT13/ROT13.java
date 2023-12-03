import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {

            if (Character.isAlphabetic(c)) {
                int sum = (int) c + 13;
                if (Character.isUpperCase(c)) {
                    if (sum > 90) {
                        System.out.print((char) ('A' + (sum - 91)));
                    } else {
                        System.out.print((char) sum);
                    }
                } else {
                    if (sum > 122) {
                        System.out.print((char) ('a' + (sum - 123)));
                    } else {
                        System.out.print((char) sum);
                    }
                }
            } else {
                System.out.print(c);
            }
        }
    }
}