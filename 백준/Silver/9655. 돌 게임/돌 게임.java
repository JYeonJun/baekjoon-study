import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String SK = "SK";
    private static final String CY = "CY";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(SK);
            return;
        } else if (N == 2) {
            System.out.println(CY);
            return;
        }

        String[] stArrays = new String[N + 1];
        stArrays[1] = SK;
        stArrays[3] = SK;

        for (int i = 1; i < N + 1; i++) {

            int p1 = i + 1;
            int p3 = i + 3;

            if (stArrays[i].equals(SK)) {

                if (p1 <= N) {
                    stArrays[i + 1] = CY;
                }
                if (p3 <= N) {
                    stArrays[i + 3] = CY;
                }
            } else if (stArrays[i].equals(CY)){
                if (p1 <= N) {
                    stArrays[i + 1] = SK;
                }
                if (p3 <= N) {
                    stArrays[i + 3] = SK;
                }
            }

            if (p1 == N || p3 == N) {
                System.out.println(stArrays[N]);
                break;
            }
        }
    }
}