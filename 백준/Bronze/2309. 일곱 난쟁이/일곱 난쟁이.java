import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final int HEIGHTS_SUM = 100;
    private static final int TOTAL_NUM = 9;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[TOTAL_NUM];
        int sum;

        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(heights);

        for (int i = 0; i < heights.length - 6; i++) {
            for (int j = i + 1; j < heights.length - 5; j++) {
                for (int k = j + 1; k < heights.length - 4; k++) {
                    for (int q = k + 1; q < heights.length - 3; q++) {
                        for (int w = q + 1; w < heights.length - 2; w++) {
                            for (int e = w + 1; e < heights.length - 1; e++) {
                                for (int t = e + 1; t < heights.length; t++) {
                                    int heightI = heights[i];
                                    int heightJ = heights[j];
                                    int heightK = heights[k];
                                    int heightQ = heights[q];
                                    int heightW = heights[w];
                                    int heightE = heights[e];
                                    int heightT = heights[t];

                                    sum = heightI + heightJ + heightK + heightQ + heightW + heightE + heightT;

                                    if (sum == HEIGHTS_SUM) {
                                        System.out.println(heightI);
                                        System.out.println(heightJ);
                                        System.out.println(heightK);
                                        System.out.println(heightQ);
                                        System.out.println(heightW);
                                        System.out.println(heightE);
                                        System.out.println(heightT);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}