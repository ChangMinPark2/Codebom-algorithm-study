package PCCE;

/**
 문제풀이흐름
 dx, dy만들고 범위 안에 있고 같은 색깔이라면 count++;
 **/
public class 이웃한칸_9 {
    public int solution(String[][] board, int h, int w) {
        String color = board[h][w];
        int count = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for(int i = 0; i < 4; i++) {
            int x = h + dx[i];
            int y = w + dy[i];

            if(isCheck(board, x, y) && board[x][y].equals(color)) count++;
        }

        return count;

    }

    private boolean isCheck(String[][] board, int x, int y) {
        int a = board.length;
        int b = board[0].length;

        return x >= 0 && x < a && y >= 0 && y < b;
    }
}
