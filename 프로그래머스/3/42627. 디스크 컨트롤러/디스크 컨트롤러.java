import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int currentTime = 0; // 현재 시간
        int totalWaitingTime = 0; // 총 대기 시간
        int completedJobs = 0; // 완료한 작업 수
        
        // 요청되는 시점 오름차순 정렬
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));
        
        // 우선순위 큐: 소요 시간이 적은 작업을 우선 처리
        PriorityQueue<int[]> jobQueue = new PriorityQueue<>(Comparator.comparingInt(job -> job[1]));
        
        int jobIndex = 0; // 요청 리스트에서 현재 작업 인덱스
        
        while (completedJobs < jobs.length) {
            // 현재 시간에 도달한 모든 작업을 큐에 추가
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime) {
                jobQueue.offer(jobs[jobIndex++]);
            }
            
            // 대기 중인 작업이 없으면 시간 증가
            if (jobQueue.isEmpty()) {
                currentTime = jobs[jobIndex][0]; // 다음 작업의 요청 시점으로 이동
                continue;
            }
            
            // 큐에서 작업 꺼내기 (소요 시간이 가장 적은 작업)
            int[] currentJob = jobQueue.poll();
            currentTime += currentJob[1]; // 작업 수행
            totalWaitingTime += currentTime - currentJob[0]; // 대기 시간 계산
            completedJobs++; // 완료한 작업 수 증가
        }
        
        // 평균 대기 시간 계산 (소수점 이하 버림)
        return totalWaitingTime / jobs.length;
    }
}