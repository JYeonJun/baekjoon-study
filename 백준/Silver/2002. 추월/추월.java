import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static Queue<String> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            que.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            String carNum = br.readLine();
            if (!carNum.equals(que.peek())) {
                que.remove(carNum);
                count++;
            } else {
                que.poll();
            }
        }

        System.out.println(count);
    }
}