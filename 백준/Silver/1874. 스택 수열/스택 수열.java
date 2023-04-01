import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer bf = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int index = 0;
        int i = 1;
        while (index < n) {

            while (i <= arr[index]) {
                stack.push(i++);
//                bw.write("+\n");
                bf.append("+\n");
            }
            Integer pop = stack.pop();
//            bw.write("-\n");
            bf.append("-\n");

            if (pop != arr[index]) {
                System.out.println("NO");
                return;
            }

            index++;
        }

        System.out.println(bf.toString());

//        bw.flush();
//        bw.close();
    }
}
