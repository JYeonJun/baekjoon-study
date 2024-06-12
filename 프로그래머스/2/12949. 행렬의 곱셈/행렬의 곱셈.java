class Solution {
    public long[][] solution(int[][] arr1, int[][] arr2) {
        return multiplyMatrices(arr1, arr2);
    }
    
    private long[][] multiplyMatrices(int[][] arr1, int[][] arr2) {
        int m = arr1.length;
        int n = arr1[0].length;
        int p = arr2[0].length;
        
        long[][] arr3 = new long[m][p];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < p; j++) {
                for(int k = 0; k < n; k++){
                    arr3[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return arr3;
    }
}