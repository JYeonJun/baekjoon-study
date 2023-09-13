import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> positiveList = new ArrayList();
        List<Integer> zeroList = new ArrayList();
        List<Integer> negativeList = new ArrayList();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                positiveList.add(num);
            } else if (num == 0) {
                zeroList.add(num);
            } else {
                negativeList.add(num);
            }
        }

        Collections.sort(positiveList, Collections.reverseOrder());
         Collections.sort(negativeList);

        long result = 0;
        while (positiveList.size() > 1) {
            Integer first = positiveList.remove(0);
            Integer second = positiveList.remove(0);

            if (first == 1 || second == 1) {
                result += first + second;
            } else {
                result += (first * second);
            }
        }

        while (negativeList.size() > 1) {
            Integer first = negativeList.remove(0);
            Integer second = negativeList.remove(0);

            result += (first * second);
        }

        if (positiveList.size() == 1) {
            result += positiveList.remove(0);
        }

        if (negativeList.size() == 1) {

            if (zeroList.size() == 0) {
                result += negativeList.remove(0);
            }
        }

        System.out.println(result);
    }
}