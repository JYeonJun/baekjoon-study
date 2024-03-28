import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> people = new HashMap<>();
        List<String> result = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputLine = br.readLine().split(" ");
            people.put(inputLine[0], people.getOrDefault(inputLine[0], 0) + 1);
        }

        people.entrySet().stream()
                .filter(p -> (p.getValue() & 1) == 1)
                .forEach(p -> result.add(p.getKey()));

        Collections.sort(result, Comparator.reverseOrder());

        for (String s : result) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}