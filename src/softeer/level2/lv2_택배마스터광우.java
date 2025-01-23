package softeer.level2;
import java.io.*;
import java.util.*;
public class lv2_택배마스터광우 {

    static int n, m, k;
    static int[] arr;
    static int[] repository;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        k = Integer.parseInt(temp[2]);
        arr = new int[n];
        repository = new int[n];
        visited = new boolean[n];

        temp = br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            answer = Math.min(answer, calculator());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                repository[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int calculator() {
        int sum = 0;
        int index = 0;

        for (int i = 0; i < k; i++) {
            int bucket = 0;

            while (repository[index] + bucket <= m) {
                bucket += repository[index];
                index = (index + 1) % n;
            }

            sum += bucket;
        }

        return sum;
    }
}
