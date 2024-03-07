package 코드봄.그래프;
import java.util.*;
public class Level3_순위 {
    static int[] win;
    static int[] lose;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int answer;

    public int solution(int n, int[][] results) {
        win = new int[n + 1];
        lose = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] arr : results) {
            int a = arr[0];
            int b = arr[1];

            graph.get(a).add(b);
        }

        for(int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }


        for(int i = 1; i <= n; i++) {
            System.out.println(i + "이김 횟수" + win[i]);
            System.out.println(i + "짐 횟수" + lose[i]);
            if(win[i] + lose[i] == n - 1) answer++;
        }

        return answer;
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int count = 0;

        while(!q.isEmpty()) {
            int a = q.remove();

            for(int i = 0; i < graph.get(a).size(); i++) {
                if(!visited[graph.get(a).get(i)]) {
                    visited[graph.get(a).get(i)] = true;
                    q.add(graph.get(a).get(i));
                    lose[graph.get(a).get(i)]++;
                    count++;
                }
            }
        }

        win[node] = count;
    }
}
