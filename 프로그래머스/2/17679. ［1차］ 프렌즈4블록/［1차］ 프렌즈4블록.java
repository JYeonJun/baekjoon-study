import java.util.*;

class Solution {
    private String[][] map;
    private int answer = 0;
    private final int[] dy = {0, 1, 1};
    private final int[] dx = {1, 1, 0};

    public int solution(int m, int n, String[] board) {
        map = new String[m][n];
        initMap(board);

        boolean checkedAny = true;

        while (checkedAny) {
            boolean[][] checked = new boolean[m][n];
            checkedAny = checkFourBlock(checked);
            replaceCheckedMap(checked);
            moveDown();
        }

        return answer;
    }

    private void initMap(String[] board) {
        for (int i = 0; i < map.length; i++) {
            String[] line = board[i].split("");
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = line[j];
            }
        }
    }

    private boolean checkFourBlock(boolean[][] checked) {
        boolean found = false;
        for (int i = 0; i < map.length - 1; i++) {
            for (int j = 0; j < map[i].length - 1; j++) {
                if (map[i][j].equals(" ")) continue;

                // 오른쪽, 오른쪽 아래, 아래 검사
                int num = 0;
                for (int k = 0; k < dy.length; k++) {
                    if (map[i][j].equals(map[i + dy[k]][j + dx[k]])) num++;
                }

                if (num == 3) {
                    if (!checked[i][j]) {
                        checked[i][j] = true;
                        answer++;
                    }
                    for (int k = 0; k < dy.length; k++) {
                        if (!checked[i + dy[k]][j + dx[k]]) {
                            checked[i + dy[k]][j + dx[k]] = true;
                            answer++;
                        }
                    }
                    found = true;
                }
            }
        }
        return found;
    }

    private void replaceCheckedMap(boolean[][] checked) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (checked[i][j]) map[i][j] = " ";
            }
        }
    }

    private void moveDown() {
        for (int j = 0; j < map[0].length; j++) {
            List<String> column = new ArrayList<>();
            for (int i = map.length - 1; i >= 0; i--) {
                if (!map[i][j].equals(" ")) {
                    column.add(map[i][j]);
                }
            }
            int index = map.length - 1;
            for (String block : column) {
                map[index--][j] = block;
            }
            while (index >= 0) {
                map[index--][j] = " ";
            }
        }
    }
}
