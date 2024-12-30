package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_15652_N과M4 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        n = Integer.parseInt(repo[0]);
        m = Integer.parseInt(repo[1]);
        arr = new int[m];

        dfs(1, 0);

        System.out.println(sb);
    }

    static void dfs(int target, int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = target; i <= n; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
