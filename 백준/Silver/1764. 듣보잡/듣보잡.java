import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> inputs = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            String input = br.readLine();
            inputs.put(input, inputs.getOrDefault(input, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (var v : inputs.entrySet()) {
            if (v.getValue() > 1) {
                count++;
                sb.append(v.getKey()).append("\n");
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }
}