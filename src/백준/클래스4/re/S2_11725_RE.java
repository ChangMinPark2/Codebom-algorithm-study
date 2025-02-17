package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S2_11725_RE {
    static boolean[] visited;
    static int[] arr;
    static int n;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] repo = br.readLine().split(" ");
            int a = Integer.parseInt(repo[0]);
            int b = Integer.parseInt(repo[1]);

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs();

        for (int i = 2; i <= n; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int parent = q.remove();

            for (int i = 0; i < list.get(parent).size(); i++) {
                if (!visited[list.get(parent).get(i)]) {
                    visited[list.get(parent).get(i)] = true;
                    arr[list.get(parent).get(i)] = parent;
                    q.add(list.get(parent).get(i));
                }
            }
        }
    }
}
