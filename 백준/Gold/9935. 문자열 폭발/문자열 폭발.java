import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb = br.readLine();

        int bombLen = bomb.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            sb.append(ch);

            int sbLen = sb.length();
            if (sbLen >= bombLen && ch == bomb.charAt(bombLen - 1)) {
                int startIndex = sbLen - bombLen;
                if (sb.substring(startIndex).equals(bomb)) {
                    sb.delete(startIndex, i + sbLen);
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}