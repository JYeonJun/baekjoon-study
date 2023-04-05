import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> myQueue = new PriorityQueue<>((o1, o2) -> {

            // 절댓값 작은 데이터 우선
            // 절댓값이 같은 경우 음수 우선
            long first_abs = Math.abs(o1);
            long second_abs = Math.abs(o2);

            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }

            return first_abs > second_abs ? 1 : -1;
        });

        for (int i = 0; i < N; i++) {
            long inputNum = Long.parseLong(br.readLine());

            if (inputNum == 0) {
                if (myQueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(myQueue.poll());
                }
            } else {
                myQueue.add(inputNum);
            }
        }
    }
}