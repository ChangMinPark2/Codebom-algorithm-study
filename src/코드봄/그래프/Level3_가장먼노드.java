package 코드봄.그래프;
/**
 1 ~ n 노드가 있는 무방향 그래프.
 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하기 -> depth의 최댓값을 알아야 한다.
 노드의 최댓값 -> 20,000 : 인접리스트로 그래프 구성하기
 <문제풀이흐름>
 간선 정보를 통해 그래프를 만든다.
 bfs를 돌리며, 각 노드에 대한 배열에 depth 를 넣으며, depth 의 최댓값을 업데이트 해준다.
 depth 배열에 요소가 depth 의 최댓값인 것을 업데이트 해준다.
 **/
import java.util.*;

public class Level3_가장먼노드 {
    static int[] mem;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public int solution(int n, int[][] edge) {
        mem = new int[n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] arr : edge) {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        bfs();

        return (int) Arrays.stream(mem)
                .filter(i -> i == max)
                .count();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visited[1] = true;

        while(!q.isEmpty()) {
            int[] temp = q.remove();
            int node = temp[0];
            int depth = temp[1];
            mem[node] = depth;
            max = Math.max(max, depth);

            for(int i = 0; i < graph.get(node).size(); i++) {
                if(!visited[graph.get(node).get(i)]) {
                    q.add(new int[] {graph.get(node).get(i), depth + 1});
                    visited[graph.get(node).get(i)] = true;
                }
            }
        }
    }
}
