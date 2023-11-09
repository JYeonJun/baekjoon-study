class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int column = arr1.length, low = arr1[0].length;
        
        int[][] answer = new int[column][low];
        
        for(int i = 0; i < column; i++) {
            for(int j = 0; j < low; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        return answer;
    }
}