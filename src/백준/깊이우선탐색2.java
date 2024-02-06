package 백준;

import java.util.*;
import java.io.*;

public class 깊이우선탐색2 {
    static int vertex, edge, start, count = 1;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visted;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        vertex = Integer.parseInt(input[0]);
        edge = Integer.parseInt(input[1]);
        start = Integer.parseInt(input[2]);
        visted = new int[vertex + 1];

        //그래프 초기화
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프 값 넣기
        for (int i = 0; i < edge; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //그래프 내림차순
        for (int i = 1; i <= vertex; i++) {
            Collections.sort(graph.get(i), ((o1, o2) -> o2 - o1));
        }

        //출력
        dfs(start);
        for (int i = 1; i <= vertex; i++) {
            System.out.println(visted[i]);
        }

    }

    static void dfs(int start) {
        visted[start] = count++;

        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);

            if (visted[next] == 0) {
                dfs(next);
            }
        }
    }
}
