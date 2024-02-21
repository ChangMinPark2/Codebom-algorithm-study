package 코드봄.탐색;
import java.util.*;
/**
 시작 위치 x: 0, y: 0 종료 위치 y: maps.length - 1 x: maps[0].length - 1;
 0 : 벽, 1: 벽 X
 최단거리 : BFS
 bfs를 돌리며 상 하 좌 우에 방문하지 않았고, 배열의 범위 안이며, 벽이 없다면
 q의 count를 +1 한 것을 넣어준다.
 **/
public class Level2_게임맵최단거리 {
    boolean[][] visited;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int maxY, maxX, answer = 0;

    public int solution(int[][] maps) {
        maxY = maps.length;
        maxX = maps[0].length;
        visited = new boolean[maxY][maxX];
        bfs(maps);

        if(!visited[maxY - 1][maxX - 1]) {
            return -1;
        }

        return answer;
    }

    void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] temp = q.remove();
            int y = temp[0];
            int x = temp[1];
            int count = temp[2];

            if(y == maxY - 1 && x == maxX - 1) {
                answer = count;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(isCheck(ny, nx) && !visited[ny][nx] && maps[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, count + 1});
                }
            }
        }
    }

    boolean isCheck(int ny, int nx) {
        return ny >= 0 && ny < maxY && nx >= 0 && nx < maxX;
    }
}
