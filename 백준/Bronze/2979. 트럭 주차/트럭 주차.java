import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int onePrice = Integer.parseInt(st.nextToken()),
                twoPrice = Integer.parseInt(st.nextToken()),
                threePrice = Integer.parseInt(st.nextToken()),
                minInTime = Integer.MAX_VALUE,
                maxOutTime = Integer.MIN_VALUE,
                result = 0;

        int[][] parkingTime = new int[3][2];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            parkingTime[i][0] = Integer.parseInt(st.nextToken());
            parkingTime[i][1] = Integer.parseInt(st.nextToken());

            minInTime = Math.min(minInTime, parkingTime[i][0]);
            maxOutTime = Math.max(maxOutTime, parkingTime[i][1]);
        }

        int[] parkingCnt = new int[maxOutTime];

        for (int i = 0; i < 3; i++) {
            int in = parkingTime[i][0];
            int out = parkingTime[i][1];

            for (int j = in; j < out; j++) {
                parkingCnt[j]++;
            }
        }

        for (int i = 1; i < parkingCnt.length; i++) {
            if (parkingCnt[i] == ONE) {
                result += onePrice * ONE;
            } else if (parkingCnt[i] == TWO) {
                result += twoPrice * TWO;
            } else if (parkingCnt[i] == THREE){
                result += threePrice * THREE;
            }
        }

        System.out.println(result);
    }
}
