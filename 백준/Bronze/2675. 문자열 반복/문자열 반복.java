import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] line;
        int R;
        char[] cArr;
        StringBuilder sb;
        for (int i = 0; i < T; i++) {
            line = br.readLine().split(" ");
            R = Integer.parseInt(line[0]);
            cArr = line[1].toCharArray();

            sb = new StringBuilder();
            for (int j = 0; j < cArr.length; j++) {
                for (int k = 0; k < R; k++) {
                    sb.append(cArr[j]);
                }
            }
            System.out.println(sb);
        }
    }
}