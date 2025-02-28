package 백준.클래스4.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_15686_RE {
    static int n, m;
    static int[][] arr;
    static List<Point> person = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);

                if (arr[i][j] == 1) {
                    person.add(new Point(i, j));
                } else if (arr[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            int sum = 0;

            for (int i = 0; i < person.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int distance = Math.abs(person.get(i).x - chicken.get(j).x)
                        + Math.abs(person.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, distance);
                    }
                }

                sum += temp;
            }
            answer = Math.min(sum, answer);
            return;
        }


        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static class Point {
        int y;
        int x;

        public Point (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
