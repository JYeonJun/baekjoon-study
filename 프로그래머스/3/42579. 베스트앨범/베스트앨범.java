import java.util.*;

class Solution {
    
    private Map<String, Integer> genresPlayMap = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new LinkedList<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            genresPlayMap.put(genre, genresPlayMap.getOrDefault(genre, 0) + plays[i]);
        }
        
        // 1. String을 두고 Map을 전부 순회하면서 value가 제일 큰 key를 String에 저장
        // 2. 해당 key에 대한 노래 2개 추가 (genres 순회하면서 pq에 추가??)
        // 3. Map에서 String에 대한 entry 제거
        PriorityQueue<Node> pq = new PriorityQueue<>();
        while(!genresPlayMap.isEmpty()) {
            String key = null;
            int count = Integer.MIN_VALUE;
            // 1. String을 두고 Map을 전부 순회하면서 value가 제일 큰 key를 String에 저장
            for(Map.Entry<String, Integer> v : genresPlayMap.entrySet()) {
                if(v.getValue() > count) {
                    key = v.getKey();
                    count = v.getValue();
                }
            }
            
            // 2. 해당 key에 대한 노래 2개 추가 (genres 순회하면서 pq에 추가??)
            pq.clear();
            for(int i = 0; i < genres.length; i++) {
                if(genres[i].equals(key)) {
                    pq.add(new Node(i, plays[i]));
                }
            }
            
            // 3. Map에서 String에 대한 entry 제거
            genresPlayMap.remove(key);
            
            for(int i = 0; i < 2; i++) {
                if(!pq.isEmpty()) {
                    answer.add(pq.poll().getIndex());
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private class Node implements Comparable<Node> {
        private int index, count;
        
        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
        
        public int getIndex() {
            return this.index;
        }
        
        @Override
        public int compareTo(Node o) {
            if(this.count == o.count) {
                return this.index - o.index;
            }
            return o.count - this.count;
        }
    }
}