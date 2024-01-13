import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int STUDENTS_COUNT = 20;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int T, sum;
        int[] students = new int[STUDENTS_COUNT];
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            sum = 0;

            for (int j = 0; j < STUDENTS_COUNT; j++) {
                students[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < STUDENTS_COUNT; j++) {
                for (int k = 0; k < j; k++) {
                    int studentJ = students[j];
                    int studentK = students[k];
                    if (studentJ < studentK) {
                        sum += j - k;
                        for (int t = j; t >= k + 1; t--) {
                            students[t] = students[t - 1];
                        }
                        students[k] = studentJ;
                    }
                }
            }

            System.out.println(T + " " + sum);
        }
    }
}