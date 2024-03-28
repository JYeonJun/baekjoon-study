import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            StringBuilder sb = new StringBuilder(input[i]);
            input[i] = sb.reverse().toString();
        }

        System.out.println(Integer.parseInt(input[0]) < Integer.parseInt(input[1]) ? input[1] : input[0]);
    }
}