package 코드봄.탐색;

import java.util.*;

/**
 * 겹쳐진 도형에 둘례 로만 BFS를 돌렸을 때 최단거리를 구하는 문제.
 * x1, y1, x2, y2, 좌표값 50이하의 자연수.
 * <문제풀이흐름>
 * rectangle 에 둘례를 1로, 내부를 2로 만들어준다.
 * 다음 도형에서 겹쳐진 부분을 둘례로 치면 안되기 때문에 2 -> continue;
 * dx, dy를 통해 charX, charY -> itemX, itemY 최단거리를 구한다.
 */
public class Level3_아이템줍기 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int answer;

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        visited = new boolean[101][101];

        for (int[] arr : rectangle) {
            int x1 = arr[0] * 2;
            int y1 = arr[1] * 2;
            int x2 = arr[2] * 2;
            int y2 = arr[3] * 2;

            for (int i = y1; i <= y2; i++) {
                for (int j = x1; j <= x2; j++) {
                    if (map[i][j] == 2) continue;
                    map[i][j] = 2;

                    if (i == y1 || i == y2 || j == x1 || j == x2) {
                        map[i][j] = 1;
                    }
                }
            }
        }
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer / 2;
    }

    static void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterY, characterX, 0});
        visited[characterY][characterX] = true;

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int y = temp[0];
            int x = temp[1];
            int count = temp[2];

            if (x == itemX && itemY == y) {
                answer = count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (isCheck(ny, nx) && !visited[ny][nx] && map[ny][nx] == 1) {
                    q.add(new int[]{ny, nx, count + 1});
                    visited[ny][nx] = true;
                }
            }
        }
    }

    static Boolean isCheck(int y, int x) {
        return y >= 0 && y < 101 && x >= 0 && x < 101;
    }

    public static void main(String[] args) {
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int characterX = 1, characterY = 3, itemX = 7, itemY = 8;
        int result = solution(rectangle, characterX, characterY, itemX, itemY);
        System.out.println(result);
    }
}
