import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] materials = new int[N];
        boolean[] exist = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 0; i < N - 1; i++) {

            if (exist[i]) continue;
            
            for (int j = i + 1; j < N; j++) {

                if (exist[j]) continue;

                if (materials[i] + materials[j] == M) {
                    result++;
                    exist[i] = true;
                    exist[j] = true;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}