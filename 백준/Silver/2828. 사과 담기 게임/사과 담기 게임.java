import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken()),
                J = Integer.parseInt(br.readLine()),
                start = 1,
                end = M,
                result = 0;

        for (int i = 0; i < J; i++) {
            int dropPoint = Integer.parseInt(br.readLine());

            if (dropPoint >= start && dropPoint <= end) {
                continue;
            } else if (dropPoint < start) {
                result += start - dropPoint;
                start = dropPoint;
                end = start + M - 1;
            } else {
                result += dropPoint - end;
                end = dropPoint;
                start = end - M + 1;
            }
        }

        System.out.println(result);
    }
}