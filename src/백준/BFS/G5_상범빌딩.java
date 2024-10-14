package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 벽: #, 빈칸: * 시작: S, 탈출구: E
 * LRC가 0으로 표현되면 종료
 */
public class G5_상범빌딩 {
    static int h, n, m;
    static char[][][] map;
    static boolean[][][] visited;
    static final int[] dx = {0, 0, -1, 1, 0, 0};
    static final int[] dy = {1, -1, 0, 0, 0, 0};
    static final int[] dz = {0, 0, 0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] repo = br.readLine().split(" ");

            h = Integer.parseInt(repo[0]); // z축
            n = Integer.parseInt(repo[1]); // y축
            m = Integer.parseInt(repo[2]); // x축

            map = new char[h][n][m];
            visited = new boolean[h][n][m];

            if (h == 0 && n == 0 && m == 0) break;

            int sh = 0;
            int sn = 0;
            int sm = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    String repo2 = br.readLine();

                    for (int z = 0; z < m; z++) {
                        map[i][j][z] = repo2.charAt(z);
                        if (repo2.charAt(z) == 'S') {
                            sh = i;
                            sn = j;
                            sm = z;
                        }
                    }
                }
                br.readLine();
            }
            bfs(sh, sn, sm);
        }
        System.out.println(sb);
    }

    static void bfs(int z, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {z, y, x, 0});
        visited[z][y][x] = true;

        while(!q.isEmpty()) {
            int[] temp = q.remove();

            int az = temp[0];
            int ay = temp[1];
            int ax = temp[2];
            int time = temp[3];

            if (map[az][ay][ax] == 'E') {
                sb.append("Escaped in ").append(time).append(" minute(s).\n");
                return;
            }


            for (int i = 0; i < 6; i++) {
                int oz = az + dz[i];
                int oy = ay + dy[i];
                int ox = ax + dx[i];

                if (isCheck(oz, oy, ox) && !visited[oz][oy][ox] && (map[oz][oy][ox] == '.' || map[oz][oy][ox] == 'E')) {
                    visited[oz][oy][ox] = true;
                    q.add(new int[] {oz, oy, ox, time + 1});
                }
            }
        }
        sb.append("Trapped!\n");
    }

    static boolean isCheck(int z, int y, int x) {
        return z >= 0 && z < h && y >= 0 && y < n && x >= 0 && x < m;
    }
}
