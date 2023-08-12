import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] sensors = new int[n];
        int[] diff = new int[n - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sensors.length; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensors);

        for (int i = 0; i < diff.length; i++) {
            diff[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(diff);

        int result = 0;
        for (int i = 0; i < n - k; i++) {
            result += diff[i];
        }

        System.out.println(result);
    }
}