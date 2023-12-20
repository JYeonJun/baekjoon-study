import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] city = new int[N];
        int[] dist = new int[N - 1];
        int cityIndex = 0;
        long ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city.length; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        while (cityIndex < N - 1) {
            int nGasPrice = city[cityIndex];
            ans += (long) nGasPrice * dist[cityIndex];

            for (int i = cityIndex + 1; i < N - 1; i++) {
                int nextGasPrice = city[i];
                if (nGasPrice < nextGasPrice) {
                    ans += (long) nGasPrice * dist[i];
                    cityIndex++;
                } else {
                    break;
                }
            }

            cityIndex++;
        }

        System.out.println(ans);
    }
}