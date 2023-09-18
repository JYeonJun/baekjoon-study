import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            HashSet<String> phoneNumbers = new HashSet<>();
            boolean isConsistent = true;

            for (int nm = 0; nm < n; nm++) {
                String phoneNumber = br.readLine();
                phoneNumbers.add(phoneNumber);
            }

            for (String phoneNumber : phoneNumbers) {
                for (int i = 1; i < phoneNumber.length(); i++) {
                    String prefix = phoneNumber.substring(0, i);
                    if (phoneNumbers.contains(prefix)) {
                        isConsistent = false;
                        break;
                    }
                }
                if (!isConsistent) {
                    break;
                }
            }

            System.out.println(isConsistent ? "YES" : "NO");
        }
    }
}