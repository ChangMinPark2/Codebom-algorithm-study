package 백준.백트래킹;
import java.util.*;
import java.io.*;
public class S3_15649 {
    static boolean[] visited;
    static int[] arr;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]); //4
        int b = Integer.parseInt(input[1]); //2
        visited = new boolean[a];
        arr = new int[b];
        dfs(a, b, 0);

    }

    static void dfs(int a, int b, int depth) {
        if (depth == b) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < a; i++) {
            if (!visited[i]) {
                visited[i]=true;
                arr[depth] = i +  1;
                dfs(a, b, depth + 1);
                visited[i] = false;
            }
        }
    }
}
