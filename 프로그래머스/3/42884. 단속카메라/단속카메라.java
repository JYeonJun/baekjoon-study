import java.util.*;

class Solution {

    public int solution(int[][] routes) {
        // 차량 경로를 종료 지점 기준으로 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int answer = 0;
        int camera = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            // 현재 설치된 카메라가 이 차량의 경로를 커버하지 못하면
            if (camera < route[0]) {
                // 새로운 카메라를 설치
                camera = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}
