import java.util.*;

class Solution {
    private static final int[] dy = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    private static final int[] dx = {0, 1, 0, -1};
    private static final int STRAIGHT = 100, CORNER = 500;

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] costs = new int[n][n][4]; // 각 방향에 대한 비용을 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Node(0, 0, 0, -1)); // (y, x, cost, direction)
        costs[0][0] = new int[]{0, 0, 0, 0}; // 시작 비용은 0
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int y = current.y, x = current.x, cost = current.cost, dir = current.direction;

            if (y == n - 1 && x == n - 1) {
                return cost; // 목적지에 도달했으면 그 비용을 반환
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if (isValid(ny, nx, n, board)) {
                    int newCost = (dir == i || dir == -1) ? cost + STRAIGHT : cost + STRAIGHT + CORNER; // 방향에 따라 비용 계산
                    if (newCost < costs[ny][nx][i]) {
                        costs[ny][nx][i] = newCost;
                        pq.add(new Node(ny, nx, newCost, i));
                    }
                }
            }
        }
        return Integer.MAX_VALUE; // 만약 경로가 없으면 (문제에서 항상 가능하다고 가정)
    }

    private boolean isValid(int y, int x, int n, int[][] board) {
        return (y >= 0 && y < n && x >= 0 && x < n && board[y][x] == 0);
    }

    private static class Node {
        int y, x, cost, direction;
        Node(int y, int x, int cost, int direction) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.direction = direction;
        }
    }
}
