import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<BigInteger> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String s1 = s.replaceAll("[^0-9]", " ");
            st = new StringTokenizer(s1.trim());

            while (st.hasMoreTokens()) {
                result.add(new BigInteger(st.nextToken()));
            }
        }

        Collections.sort(result);
        for (BigInteger i : result) {
            System.out.println(i);
        }
    }
}