import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i)); // 현재 문자를 StringBuilder에 추가합니다.
            
            // 폭발 문자열의 마지막 문자와 동일하고, 현재 sb의 길이가 폭발 문자열의 길이보다 크거나 같은 경우,
            // 폭발 문자열이 sb에 포함되어 있는지 확인합니다.
            if (sb.length() >= bomb.length() && input.charAt(i) == bomb.charAt(bomb.length() - 1)) {
                // sb의 끝에서 폭발 문자열의 길이만큼 잘라내 폭발 문자열과 동일한지 확인합니다.
                if (sb.substring(sb.length() - bomb.length()).equals(bomb)) {
                    // 폭발 문자열과 동일하다면, 폭발 문자열을 sb에서 제거합니다.
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
