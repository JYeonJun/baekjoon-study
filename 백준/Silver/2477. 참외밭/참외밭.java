import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] lens = new int[6];
    private static int maxHeightIdx = 0, maxWidthIdx = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        int maxWidth = Integer.MIN_VALUE, maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int len = Integer.parseInt(st.nextToken());
            lens[i] = len;
            switch (dir) {
                case "1": case "2":
                    if (maxWidth < len) {
                        maxWidth = len;
                        maxWidthIdx = i;
                    }
                    break;
                case "3": case "4":
                    if (maxHeight < len) {
                        maxHeight = len;
                        maxHeightIdx = i;
                    }
                    break;
            }
        }

        System.out.println(K * (maxWidth * maxHeight - calSubAreaSize()));
    }

    private static int calSubAreaSize() {
        return Math.abs(lens[maxHeightIdx - 1 < 0 ? 5 : maxHeightIdx - 1] - lens[(maxHeightIdx + 1) % 6])
                * Math.abs(lens[maxWidthIdx - 1 < 0 ? 5 : maxWidthIdx - 1] - lens[(maxWidthIdx + 1) % 6]);
    }
}