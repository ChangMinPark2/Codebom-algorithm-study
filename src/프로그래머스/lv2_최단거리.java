package 프로그래머스;
import java.util.*;

public class lv2_최단거리 {
    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};
    boolean[][] visited;

    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }

    private int bfs(int[][] arr) {
        Deque<int[]> q = new ArrayDeque<>();
        visited = new boolean[arr.length][arr[0].length];
        q.add(new int[]{0, 0, 1});

        while(!q.isEmpty()) {
            int[] temp = q.remove();
            int y = temp[0];
            int x = temp[1];
            int score = temp[2];

            if(y == arr.length - 1 && x == arr[0].length - 1) {
                return score;
            }

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(isCheck(ny, nx, arr) && !visited[ny][nx] && arr[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.add(new int[] {ny, nx, score + 1});
                }
            }

        }

        return -1;
    }

    private boolean isCheck(int y, int x, int[][] arr) {
        return y >= 0 && y < arr.length && x >= 0 && x < arr[0].length;
    }

}
