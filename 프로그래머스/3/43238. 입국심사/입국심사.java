class Solution {
    
    public long solution(int n, int[] times) {
        long left = 0;
        long right = (long) n * (long) times[times.length - 1]; // 최대 대기 시간
        long answer = right; // 초기값을 가장 큰 값으로 설정
        
        while (left < right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            for (int time : times) {
                sum += mid / time; // mid 시간 내에 처리 가능한 인원 수
            }
            
            if (sum >= n) { // 모든 인원이 심사를 받을 수 있는 경우
                answer = mid; // 가능한 답을 갱신
                right = mid; // 더 작은 시간도 탐색
            } else {
                left = mid + 1; // 더 큰 시간으로 탐색
            }
        }
        
        return answer;
    }
}