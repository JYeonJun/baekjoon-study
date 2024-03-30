import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int ALPHA_COUNT = 26;
    private static final int ASCII_A = 65;
    private static int[] alphaFrequency = new int[ALPHA_COUNT];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            alphaFrequency[charArray[i] - ASCII_A]++;
        }

        if (isNope(charArray.length)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ALPHA_COUNT; i++) {
            sb.append(String.valueOf((char)(i + ASCII_A)).repeat(alphaFrequency[i] / 2));
        }

        String start = sb.toString();
        String end = sb.reverse().toString();

        sb.setLength(0);
        for (int i = 0; i < ALPHA_COUNT; i++) {
            if ((alphaFrequency[i] & 1) == 1) {
                sb.append((char) (i + ASCII_A));
            }
        }

        System.out.println(start + sb + end);
    }

    private static boolean isNope(int len) {
        return countOddFrequency() > 1;
    }

    private static int countOddFrequency() {
        int count = 0;
        for (int i = 0; i < ALPHA_COUNT; i++) {
            if (alphaFrequency[i] % 2 == 1) {
                count++;
            }
        }
        return count;
    }
}