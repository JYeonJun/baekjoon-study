import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int switchCnt, studentCnt;
    private static int[] switchStatus;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switchCnt = Integer.parseInt(br.readLine()); // 스위치 개수
        switchStatus = new int[switchCnt + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchCnt; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }
        studentCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {// 남학생인 경우
                for (int j = 1; j <= switchCnt; j++) {
                    if (j % num == 0) {
                        turnOnOff(j);
                    }
                }
            } else { // 여학생인 경우
                turnOnOff(num);
                int tmp = 1;
                while (true) {
                    int preIndex = num - tmp;
                    int nextIndex = num + tmp;
                    if (preIndex >= 1 && nextIndex <= switchCnt) {
                        if (switchStatus[preIndex] == switchStatus[nextIndex]) {
                            turnOnOff(preIndex);
                            turnOnOff(nextIndex);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                    tmp++;
                }
            }
        }

        for (int i = 1; i <= switchCnt; i++) {
            System.out.print(switchStatus[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static void turnOnOff(int index) {
        if (switchStatus[index] == 0) {
            switchStatus[index] = 1;
        } else {
            switchStatus[index] = 0;
        }
    }
}