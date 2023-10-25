import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        String[] arr = s.split(" ");
        
        int[] intArr = Arrays.stream(arr).mapToInt(i -> Integer.parseInt(i)).toArray();
        
        Arrays.sort(intArr);
        
        answer.append(intArr[0] + " ");
        answer.append(intArr[intArr.length - 1]);
        
        return answer.toString();
    }
}