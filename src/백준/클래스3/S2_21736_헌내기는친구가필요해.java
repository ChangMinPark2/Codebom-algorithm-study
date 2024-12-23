package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * n과 m이 600, 인접리스트로 해야할듯 ?
 */
public class S2_21736_헌내기는친구가필요해 {
    private final static int[] dx = {0, 0, -1, 1};
    private final static int[] dy = {1, -1, 0, 0};
    private static List<List<String>> list = new ArrayList<>();
    private static boolean[][] visited;
    private static int sX;
    private static int sY;
    private static int answer = 0;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        n = Integer.parseInt(repo[0]);
        m = Integer.parseInt(repo[1]);

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                if (temp[j].equals("I")) {
                    sX = j;
                    sY = i;
                }
                list.get(i).add(temp[j]);
            }
        }

        bfs();

        System.out.println(answer == 0 ? "TT" : answer);
    }

    private static void bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sY, sX});
        visited[sY][sX] = true;

        while (!q.isEmpty()) {
            int[] temp = q.remove();

            int ny = temp[0];
            int nx = temp[1];

            for (int i = 0; i < 4; i++) {
                int oy = ny + dy[i];
                int ox = nx + dx[i];

                if (check(oy, ox) && !visited[oy][ox] & !list.get(oy).get(ox).equals("X")) {
                    q.add(new int[] {oy, ox});
                    visited[oy][ox] = true;
                    if (list.get(oy).get(ox).equals("P")) answer++;
                }
            }
        }
    }

    private static boolean check(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
