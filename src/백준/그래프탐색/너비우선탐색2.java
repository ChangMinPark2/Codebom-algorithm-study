package 백준.그래프탐색;
import java.io.*;
import java.util.*;
public class 너비우선탐색2 {
    static int vertex, edge, start, count = 1;
    static int[] visited;
    static List<List<Integer>> graph= new ArrayList<>();
    public static void main(String[] args) throws Exception{
        //입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        vertex = Integer.parseInt(input[0]);
        edge = Integer.parseInt(input[1]);
        start = Integer.parseInt(input[2]);
        visited = new int[vertex + 1];
        //그래프 초기화하기
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }
        //그래프 값넣기
        for (int i = 0; i < edge; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        //내림차순하기
        for (int i = 1; i <= vertex; i++) {
            Collections.sort(graph.get(i), (o1, o2) -> o2 - o1);
        }
        //bfs이후 출력하기
        bfs(start);
        for (int i = 1; i <= vertex; i++) {
            System.out.println(visited[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = count++;
        q.add(start);

        while(!q.isEmpty()) {
            int standard = q.remove();

            for (int i = 0; i < graph.get(standard).size(); i++) {
                int next = graph.get(standard).get(i);

                if (visited[next] == 0) {
                    q.add(next);
                    visited[next] = count++;
                }
            }
        }
    }
}
