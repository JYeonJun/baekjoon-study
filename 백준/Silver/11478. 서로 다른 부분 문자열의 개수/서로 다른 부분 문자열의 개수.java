import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length(), sum = 0;
        Set<String> alphaCombinations = new HashSet<>();

        for (int i = 1; i <= len; i++) {
            sum += len - i + 1;
            for (int j = 0; (j < len) && ((j + i) <= len); j++) {
                alphaCombinations.add(input.substring(j, i + j));
            }
        }

        System.out.println(alphaCombinations.size());
    }
}