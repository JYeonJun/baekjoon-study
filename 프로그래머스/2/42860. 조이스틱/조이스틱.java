class Solution {
    public int solution(String name) {
        int length = name.length();
        int move = length - 1;  // 오른쪽으로 쭉 간다고 가정한 초기 이동 횟수
        
        int answer = 0;
        for (int i = 0; i < length; i++) {
            char ch = name.charAt(i);
            // 현재 문자를 변경하는 최소 횟수
            answer += Math.min(ch - 'A', 'Z' - ch + 1);
            
            // 다음 위치로 이동하는 최소 횟수 계산
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i + length - next + Math.min(i, length - next));
        }
        
        answer += move;
        return answer;
    }
}
