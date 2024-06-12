import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 1;
        
        while(n > 1) {
            if ((n & 1) == 0) { // 짝수인 경우
                n /= 2; // 2로 나누기
            } else {
                answer++;
                n--;
            }
        }
        
        return answer;
    }
}