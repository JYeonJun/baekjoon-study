import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int[] arr = set.stream().mapToInt(Integer::intValue).toArray();

        int[] result = new int[2];

        int min = Integer.MAX_VALUE;

        int i = 0;
        int j = arr.length -1 ;
        while (i < j) {

            Integer small = arr[i];
            Integer big = arr[j];
            int sum = small + big;

            if (sum == 0) {
                result[0] = small;
                result[1] = big;
                break;
            }

            if (abs(min) > abs(sum)) {
                min = abs(sum);
                result[0] = small;
                result[1] = big;
            } else if (sum < 0) {
                i++;
            } else{
                j--;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}