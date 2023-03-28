import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[] dnaArr;

    static int[] myArr; // A, C, G, T

    static int[] checkArr;

    public static void main(String[] args) throws IOException {

        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        myArr = new int[4];
        checkArr = new int[4];

        dnaArr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            addCnt(i);
        }

        if (checkCnt()) {
            result++;
        }

        int i = 1;
        int j = i + P - 1;
        for (; j < S; i++, j++) {
            addCnt(j);
            subtractCnt(i - 1);
            if (checkCnt()) {
                result++;
            }
        }

        System.out.println(result);
    }

    static void addCnt(int index) {
        char alpha = dnaArr[index];

        switch (alpha) {
            case 'A':
                myArr[0]++;
                break;
            case 'C':
                myArr[1]++;
                break;
            case 'G':
                myArr[2]++;
                break;
            case 'T':
                myArr[3]++;
                break;
        }
    }

    static void subtractCnt(int index) {
        char alpha = dnaArr[index];

        switch (alpha) {
            case 'A':
                myArr[0]--;
                break;
            case 'C':
                myArr[1]--;
                break;
            case 'G':
                myArr[2]--;
                break;
            case 'T':
                myArr[3]--;
                break;
        }
    }

    static boolean checkCnt() {

        for (int i = 0; i < 4; i++) {
            if (myArr[i] < checkArr[i]) {
                return false;
            }
        }
        return true;
    }
}