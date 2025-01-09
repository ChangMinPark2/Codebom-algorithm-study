package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 3차원 배열 bfs
 * <p>
 * 모든 토마토가 익어있는 상태이면 0 출력.
 * 토마토가 모두 익지 못하는 상황이면 -1을 출력해야한다.
 * <p>
 * 동시에 시작해야하기 때문에, q에 1을 넣고 시작해보자.
 * 가로 세로 높이 순서로 줌
 */
public class G5_7569_토마토 {
    private static final int[] dx = {0, 0, -1, 1, 0, 0};
    private static final int[] dy = {1, -1, 0, 0, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, 1, -1};
    static int z,y,x;
    static int answer;
    static boolean[][][] visited;
    static int[][][] arr;
    static Deque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        x = Integer.parseInt(repo[0]);
        y = Integer.parseInt(repo[1]);
        z = Integer.parseInt(repo[2]);

        arr = new int[z][y][x];
        visited = new boolean[z][y][x];

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                String[] temp = br.readLine().split(" ");

                for (int z = 0; z < x; z++) {
                    arr[i][j][z] = Integer.parseInt(temp[z]);
                    if (arr[i][j][z] == 1) {
                        q.add(new int[] {i, j, z, 0});
                        visited[i][j][z] = true;
                    }
                }
            }
        }

        answer = 0;

        bfs();

        for (int [][] i: arr) {
            for (int[] j : i) {
                for (int z : j) {
                    if (z == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.remove();

            int nz = temp[0];
            int ny = temp[1];
            int nx = temp[2];
            int score = temp[3];
            answer = score;

            for (int i = 0; i < 6; i++) {
                int oz = nz + dz[i];
                int oy = ny + dy[i];
                int ox = nx + dx[i];

                if (isCheck(oz, oy, ox) && !visited[oz][oy][ox] && arr[oz][oy][ox] == 0) {
                    visited[oz][oy][ox] = true;
                    arr[oz][oy][ox] = 1;
                    q.add(new int[] {oz, oy, ox, score + 1});
                }
            }
        }
    }

    private static boolean isCheck(int nz, int ny, int nx) {
        return nz >= 0 && nz < z && ny >= 0 && ny < y && nx >= 0 && nx < x;
    }
}
