import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Node> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        int[] resultArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {

            int now = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek().valueNum < now) {
                    Node node = stack.pop();
                    resultArr[node.index] = now;
                } else {
                    break;
                }
            }

            stack.push(new Node(i, now));
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            resultArr[node.index] = -1;
        }

        for (int i : resultArr) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Node {

        public int index;
        public int valueNum;

        public Node(int index, int valueNum) {
            this.index = index;
            this.valueNum = valueNum;
        }
    }
}