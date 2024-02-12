package 백준.트리;
import java.util.*;
import java.io.*;

/*
입력 값 n의 노드가 주어진다.
둘째 줄부터 연결된 두 정점을 준다.
트리의 루트가 1일때, 각 노드의 부모 노드를 출력하는 문제이다.
2번부터 순서대로 출력한다.
 */
public class 트리의부모노드찾기 {
    static int node;
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        answer = new int[node + 1];
        visited = new boolean[node + 1];
        //트리 초기화
        for (int i = 0; i <= node; i++) {
            tree.add(new ArrayList<>());
        }

        //트리 값넣기
        for (int i = 0; i < node - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1);

        for (int i = 2; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int i : tree.get(node)) {
            if (!visited[i]) {
                answer[i] = node;
                dfs(i);
            }
        }
    }
}
