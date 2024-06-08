import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        char[] charArray = s.toCharArray();
        
        for (char c : charArray) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        
        if (stack.size() != 0) {
                    answer = false;
        }

        return answer;
    }
}