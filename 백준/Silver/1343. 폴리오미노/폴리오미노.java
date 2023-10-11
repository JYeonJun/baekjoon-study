import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();

        String result = poliomino(board);

        System.out.println(result);
    }

    private static String poliomino(String board) {

        String A = "AAAA", B = "BB";

        board = board.replaceAll("XXXX", A);
        String result = board.replaceAll("XX", B);

        if (result.contains("X")) {
            result = "-1";
        }

        return result;
    }
}