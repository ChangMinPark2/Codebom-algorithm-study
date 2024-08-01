package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1 ~ 49 중에서 6개를 고른다.
 * 49가지의 수 중에서 6개를 골라 집합 S를 만들고, 그 수를 가지고 번호를 선택하는 것
 *
 */
public class S2_6603 {
    static boolean[] visited;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;

            String[] repo = input.split(" ");
            int n = Integer.parseInt(repo[0]);

            result = new int[6];
            arr = new int[n];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(repo[i + 1]);
            }

            dfs(0, n, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int n, int start) {
        if (depth == 6) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                dfs(depth + 1, n, i);
                visited[i] = false;
            }
        }
    }
}
