import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String board = br.readLine();

        char[] boardArray = board.toCharArray();

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        int loop;
        for (char c : boardArray) {

            if (c == 'X') {
                cnt++;
            } else { // c == '.'

                if (cnt % 2 == 0) { // 짝수인지 판단

                    loop = cnt / 4;

                    for (int j = 0; j < loop; j++) {
                        sb.append("AAAA");
                    }

                    if (cnt % 4 == 2) {

                        sb.append("BB");
                    }

                    sb.append(".");
                } else {
                    System.out.print(-1);
                    return;
                }
                cnt = 0;
            }
        }

        if (cnt != 0) {
            if (cnt % 2 == 0) { // 짝수인지 판단

                loop = cnt / 4;

                for (int j = 0; j < loop; j++) {
                    sb.append("AAAA");
                }

                if (cnt % 4 == 2) {

                    sb.append("BB");
                }
            } else {
                System.out.print(-1);
                return;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}