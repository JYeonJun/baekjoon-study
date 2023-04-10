import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split("");
        List<Integer> num = Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
        num.sort((n1, n2) -> {
            return n2 - n1;
        });

        for (Integer integer : num) {
            System.out.print(integer);
        }
    }
}