import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int NUM = 65;
    private static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stdArr = new int[NUM];
        String standard = br.readLine();
        calAlpha(stdArr, standard);
        for (int i = 0; i < N - 1; i++) {
            int[] comArr = new int[NUM];
            String com = br.readLine();
            calAlpha(comArr, com);
            compare(stdArr, comArr);
            calResult(comArr);
        }

        System.out.println(result);
    }

    private static void calResult(int[] arr) {
        int tmp = 0;
        int tmp2 = 0;
        for (int i = 0; i < NUM; i++) {
            if (arr[i] != 0) {
                tmp += (arr[i] < 0) ? arr[i] * -1 : arr[i];
                tmp2 += arr[i];
            }
        }

        if (tmp <= 1 || (tmp == 2 && tmp2 == 0)) {
            result++;
        }
    }

    private static void compare(int[] stdArr, int[] comArr) {
        for (int i = 0; i < NUM; i++) {
            comArr[i] -= stdArr[i];
        }
    }

    private static void calAlpha(int[] arr, String string) {
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            arr[(int) charArray[i] - NUM]++;
        }
    }
}