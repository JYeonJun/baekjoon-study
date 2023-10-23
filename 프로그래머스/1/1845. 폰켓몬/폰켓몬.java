import java.util.*;

class Solution {
    public int solution(int[] nums) { // nums: N마리 폰켓몬의 종류 번호가 담긴 배열
        
        int answer, mid, setSize;
        
        mid = nums.length / 2;
        
        Set<Integer> set = new HashSet();
        
        for (int i : nums) {
            set.add(i);
        }

        setSize = set.size();
        
        if (setSize == mid) {
            answer = setSize;
        } else if (setSize < mid) {
            answer = setSize;
        } else {
            answer = mid;
        }
        
        return answer;
    }
}