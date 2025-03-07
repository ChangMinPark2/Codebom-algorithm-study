package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <= 8
 * 자기자신 포함 x -> 전부탐색 visited
 * 중복 수열 불가 -> set
 */

public class S2_15663_N과M92 {
    static int n, m;
    static int[] answer;
    static int[] arr;
    static boolean[] visited;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        n = Integer.parseInt(repo[0]);
        m = Integer.parseInt(repo[1]);
        answer = new int[m];
        visited = new boolean[n];

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        dfs(0);

        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void dfs(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();

            for (int i : answer) {
                sb.append(i).append(" ");
            }

            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
             }
        }
    }
}
