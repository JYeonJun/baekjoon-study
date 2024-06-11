import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>((n1, n2) -> n2 - n1);
        
        for(int n : A) {
            a.add(n);
        }
        
        for(int n: B) {
            b.add(n);
        }
        
        while(a.size() > 0) {
            int num1 = a.poll();
            int num2 = b.poll();
            answer += num1 * num2;
        }

        return answer;
    }
}