package 코드봄.탐욕;

import java.util.*;
public class Level3_섬연결하기 {
    static int[] parents;
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, ((o1, o2) -> o1[2] - o2[2]));

        for (int[] arr : costs) {
            int from = arr[0];
            int to = arr[1];
            int cost = arr[2];

            if (find(from) != find(to)){
                union(from, to);
                answer += cost;
            }
        }
        return answer;
    }

    static int find(int vertex) {
        if (parents[vertex] == vertex) return vertex;
        else return parents[vertex] = find(parents[vertex]);
    }

    static void union (int from, int to) {
        from = find(from);
        to = find(to);
        if (from != to) parents[to] = from;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 1},
                {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int n = 4;

        System.out.println(solution(n, arr));
    }

}
