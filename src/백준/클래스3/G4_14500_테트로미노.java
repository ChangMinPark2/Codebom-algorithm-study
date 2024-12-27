package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * N >= 4 , M <= 500 : 탐색, 2차원 DP, 플로이드워셜
 *
 * 1 * 1 크기의 정사각형을 여러개 이어서 붙인 도형이다.
 * 정사각형은 서로 겹치면 안 된다.
 * 도형은 모두 연결되어 있어야 한다.
 * 정사각형의 변끼리 연결되어 있어야 한다
 *
 * N * M 위에 테트로미노를 하나 놓으려고 한다.
 * 종이는 1 * 1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.
 * 테트로미노 하나를 적절히 놓아서, 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램 작성하기.
 *
 */
public class G4_14500_테트로미노 {
    static int n, m;
    static int answer = Integer.MIN_VALUE;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]); //세로
        m = Integer.parseInt(repo[1]); //가로
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                list.get(i).add(Integer.parseInt(temp[j]));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, list.get(i).get(j));
                visited[i][j] = false;

                combi(0, 0, i, j, list.get(i).get(j));
            }
        }

        System.out.println(answer);
    }

    private static void combi(int count, int start, int y, int x, int sum) {
        if (count == 3) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = start; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isCheck(ny, nx)) {
                combi(count + 1, i + 1, y, x, sum + list.get(ny).get(nx));
            }
        }
    }

    private static void dfs(int y, int x, int count, int sum) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isCheck(ny, nx) && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(ny, nx, count + 1, sum + list.get(ny).get(nx));
                visited[ny][nx] = false;
            }
        }
    }

    private static boolean isCheck(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
