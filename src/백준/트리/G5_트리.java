package 백준.트리;
import java.io.*;
import java.util.*;

public class G5_트리 {
    static int node, root, delete, count = 0;
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        visited = new boolean[node];

        for (int i = 0; i < node; i++) {
            tree.add(new ArrayList<>());
        }

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < node; i++) {
            if (Integer.parseInt(input[i]) == -1) {
                root = i;
            } else {
                tree.get(Integer.parseInt(input[i])).add(i);
            }
        }

        delete = Integer.parseInt(br.readLine());
//        visited[delete] = true;

        if (delete == root) {
            System.out.println(0);
            return;
        }

        dfs(root);

        System.out.println(count);
    }

    static void dfs(int node) {
        boolean check = false;
        //리프노드의 갯수
        if (tree.get(node).isEmpty()) {
            count++;
            return;
        }
        //
        for (int i : tree.get(node)) {
            if (i != delete) {
                dfs(i);
                check = true;
            }
        }

        if (!check) {
            count++;
        }
    }
}
