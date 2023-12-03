import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] charArray = s.toCharArray();
        int[] answer = new int[26];

        for (char c : charArray) {
            switch(c) {
                case 'a':
                    answer[0]++;
                    break;
                case 'b':
                    answer[1]++;
                    break;
                case 'c':
                    answer[2]++;
                    break;
                case 'd':
                    answer[3]++;
                    break;
                case 'e':
                    answer[4]++;
                    break;
                case 'f':
                    answer[5]++;
                    break;
                case 'g':
                    answer[6]++;
                    break;
                case 'h':
                    answer[7]++;
                    break;
                case 'i':
                    answer[8]++;
                    break;
                case 'j':
                    answer[9]++;
                    break;
                case 'k':
                    answer[10]++;
                    break;
                case 'l':
                    answer[11]++;
                    break;
                case 'm':
                    answer[12]++;
                    break;
                case 'n':
                    answer[13]++;
                    break;
                case 'o':
                    answer[14]++;
                    break;
                case 'p':
                    answer[15]++;
                    break;
                case 'q':
                    answer[16]++;
                    break;
                case 'r':
                    answer[17]++;
                    break;
                case 's':
                    answer[18]++;
                    break;
                case 't':
                    answer[19]++;
                    break;
                case 'u':
                    answer[20]++;
                    break;
                case 'v':
                    answer[21]++;
                    break;
                case 'w':
                    answer[22]++;
                    break;
                case 'x':
                    answer[23]++;
                    break;
                case 'y':
                    answer[24]++;
                    break;
                case 'z':
                    answer[25]++;
                    break;
            }
        }

        for(int i : answer) {
            System.out.print(i + " ");
        }
    }
}