import java.util.*;

class Solution {
    private Set<Integer> result = new HashSet<>();
    private String[] arr;

    public int solution(String numbers) {
        arr = numbers.split("");

        for (int i = 1; i <= arr.length; i++) {
            permutation(new boolean[arr.length], new StringBuilder(), i);
        }

        return result.size();
    }

    private void permutation(boolean[] visited, StringBuilder output, int n) {
        if (output.length() == n) {
            // 정수로 변환
            String str = output.toString();
            int num = Integer.parseInt(str);
            // 소수인지 검사
            // 소수라면 Set에 저장
            if (isPrime(num)) {
                result.add(num);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output.append(arr[i]);
                permutation(visited, output, n);
                visited[i] = false;
                output.deleteCharAt(output.length() - 1);  // 마지막에 추가된 문자 제거
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;  // 0과 1은 소수가 아님

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
