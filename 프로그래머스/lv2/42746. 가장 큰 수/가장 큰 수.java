import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        StringBuilder result = new StringBuilder();
        String[] strArr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo((o1 + o2)));
        
        if(strArr[0].charAt(0) == '0') {
            return "0";
        }
        
        for(String str : strArr) {
            result.append(str);
        }
        
        return result.toString();
    }
}