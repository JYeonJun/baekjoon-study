import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final String ADD = "add";
    private static final String REMOVE = "remove";
    private static final String CHECK = "check";
    private static final String TOGGLE = "toggle";
    private static final String ALL = "all";
    private static final String EMPTY = "empty";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int S = 0;

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            if (str.equals(ALL)) {
                S = (1 << 21) - 1;
            } else if (str.equals(EMPTY)) {
                S = 0;
            } else {
                int num = Integer.parseInt(st.nextToken());
                if (str.equals(ADD)) {
                    S |= (1 << num);
                } else if (str.equals(REMOVE)) {
                    S &= ~(1 << num);
                } else if (str.equals(CHECK)) {
                    sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                } else if (str.equals(TOGGLE)) {
                    S ^= (1 << num);
                }
            }
        }

        System.out.println(sb);
    }
}