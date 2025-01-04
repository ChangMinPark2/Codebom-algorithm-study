package 백준.클래스4;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * N -> 50개, M -> 13개. (완탐, 백트래킹)
 * 0 빈칸, 1 집, 2 치킨집
 * 도시에 있는 치킨집은 모두 같은 프랜차이즈.
 * 수익을 증가시키기 위해서 일부 치킨집을 폐업시킨다.
 * 연구 끝에 이 도시에서 가장 수익을 많이 낼 수 있는 치킨집의 개수는 최대 M 개이다.
 * 치킨 집 중에서, 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시킨다.
 * 어떻게 고르면 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램
 * 폐업을 시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 구하기
 */
public class G5_15686_치킨배달 {
    static int n, m;
    static int[][] arr;
    static boolean[] visited;
    static List<int[]> home = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]);
        m = Integer.parseInt(repo[1]);
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);

                if (Integer.parseInt(temp[j]) == 1) {
                    home.add(new int[]{i, j});
                } else if (Integer.parseInt(temp[j]) == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int start) {
        // 종료
        if (depth == m) {
            int sum = 0;

            for (int[] h : home) {
                int min = Integer.MAX_VALUE;

                for (int i = 0; i < chicken.size(); i++) {
                    if (visited[i]) {
                        int distance = Math.abs(h[0] - chicken.get(i)[0]) +
                                Math.abs(h[1] - chicken.get(i)[1]);

                        min = Math.min(min, distance);
                    }
                }
                sum += min;
            }
            answer = Math.min(answer, sum);

            return;
        }

        // 탐색
        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
