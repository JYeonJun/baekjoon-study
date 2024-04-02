import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder compressedIpv6 = new StringBuilder(br.readLine());
        String[] splitIpv6 = compressedIpv6.toString().split(":");
        int compressedIndex = compressedIpv6.indexOf("::");
        if (compressedIndex != -1) {
            int cnt = 0;
            for (String s : splitIpv6) {
                if (s.length() != 0) {
                    cnt++;
                }
            }
            compressedIpv6.insert(compressedIndex + 1, "0000:".repeat(8 - cnt));
        }
        String tmp = compressedIpv6.toString().replace("::", ":");
        if (tmp.endsWith(":")) {
            tmp = tmp.substring(0, tmp.length() - 1);
        }
        String[] tt = tmp.split(":");

        StringBuilder sb = new StringBuilder();
        for (String s : tt) {
            if (s.length() > 0 && s.length() < 4) {
                sb.append("0".repeat(4 - s.length())).append(s);
            } else if (s.length() == 4){
                sb.append(s);
            }
            sb.append(":");
        }

        if (sb.toString().endsWith(":")) {
            sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        }

        if (sb.toString().startsWith(":")) {
            sb = new StringBuilder(sb.substring(1));
        }
        System.out.println(sb);
    }
}