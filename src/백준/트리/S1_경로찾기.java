package 백준.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class S1_경로찾기 {
    static int[][] graph;
    static int vertex;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        vertex = Integer.parseInt(br.readLine());

        graph = new int[vertex][vertex];

        for (int i = 0; i < vertex; i++) {
            String[] repo = br.readLine().split(" ");

            for (int j = 0; j < vertex; j++) {
                graph[i][j] = Integer.parseInt(repo[j]);
            }
        }

        for (int k = 0; k < vertex; k++) {
            for (int i = 0; i < vertex; i++) {
                for (int j = 0; j < vertex; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
