import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> voca = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.length() < M) {
                continue;
            }
            Integer value = voca.getOrDefault(str, 0);
            voca.put(str, value + 1);
        }

        List<String> keySet = new ArrayList<>(voca.keySet());

        keySet.sort((o1, o2) -> {
            if (Integer.compare(voca.get(o1), voca.get(o2)) != 0) {
                return voca.get(o2).compareTo(voca.get(o1));
            }

            if (o1.length() != o2.length()) {
                return Integer.compare(o2.length(), o1.length());
            }

            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : keySet) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}