package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class G4_1967_트리의지름 {
    static int n;
    static List<Node>[] list;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] temp = br.readLine().split(" ");
            int parent = Integer.parseInt(temp[0]);
            int child = Integer.parseInt(temp[1]);
            int distance = Integer.parseInt(temp[2]);

            list[parent].add(new Node(child, distance));
            list[child].add(new Node(parent, distance));
        }

        answer = 0;

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(answer);
    }

    private static void dfs(int num, int sum) {
        for (Node node : list[num]) {
            if (!visited[node.num]) {
                visited[node.num] = true;
                dfs(node.num, sum + node.length);
            }
        }

        answer = answer < sum ? sum : answer;
    }

    static class Node {
        int num;
        int length;

        public Node(int num, int length) {
            this.num = num;
            this.length = length;
        }
    }
}
