package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class S2_15665 {
    static int[] map;
    static boolean[] visited;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int n = Integer.parseInt(repo[0]);
        int m = Integer.parseInt(repo[1]);

        map = new int[m];
        visited = new boolean[n];

        dfs(n, m, 0, arr);

        for (String s : set) {
            System.out.println(s);
        }
    }

    static void dfs(int n, int m, int depth, int[] arr) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : map) {
                sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            map[depth] = arr[i];
            dfs(n, m, depth + 1, arr);
        }
    }
}

