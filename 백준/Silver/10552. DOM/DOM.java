import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int CHANNEL_CNT = 100_000;
    private static int count = 0;
    private static int[] toFavouriteCh = new int[CHANNEL_CNT + 1];
    private static boolean[] visited = new boolean[CHANNEL_CNT + 1];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int fCh, hCh;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            fCh = Integer.parseInt(st.nextToken());
            hCh = Integer.parseInt(st.nextToken());

            if (toFavouriteCh[hCh] == 0) {
                toFavouriteCh[hCh] = fCh;
            }
        }

        changeChannel(P);
        System.out.println(count);
    }

    private static void changeChannel(int channel) {

        if (visited[channel]) count = -1;
        else if (toFavouriteCh[channel] != 0) {
            count++;
            visited[channel] = true;
            changeChannel(toFavouriteCh[channel]);
        }
    }
}