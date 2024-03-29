import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final String ENTER = "ENTER";
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static final Map<String, Integer> enterCount = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int result = processNames();

        System.out.println(result);
    }

    private static int processNames() throws IOException {
        int result = 0;
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            result += updateEnterCount(name);
        }
        return result;
    }

    private static int updateEnterCount(String name) {
        if (ENTER.equals(name)) {
            enterCount.clear();
            return 0;
        }
        if (!enterCount.containsKey(name)) {
            enterCount.put(name, 1);
            return 1;
        }
        return 0;
    }
}