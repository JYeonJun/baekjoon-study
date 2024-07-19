import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int aIndex = 0, bIndex = 0;
        int points = 0;

        while (bIndex < B.length) {
            if (B[bIndex] > A[aIndex]) {
                points++;
                aIndex++;
            }
            bIndex++;
        }

        return points;
    }
}
