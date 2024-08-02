package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 열쇠를 잃어버려 암호 시스템 개설
 * 서로 다른 L개의 알파벳 소문자 구성. 최소 한 개의 모음과 최소 두 개의 자음으로 구성되어 있음
 * 오름차순 정렬.
 * 조교들이 암호로 사용했을 법한 문자의 종류는 C가지
 * 주목해야할 점은 최소 한 개의 모음이 있는가이다.
 * C는 3이상이다.
 */
public class G5_1759 {
    static String[] map;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        int a = Integer.parseInt(repo[0]);
        int b = Integer.parseInt(repo[1]);

        map = new String[a]; //4
        visited = new boolean[b]; //6

        String[] str = br.readLine().split(" ");
        Arrays.sort(str);
        dfs(a, b, 0, 0, str);
        System.out.println(sb);
    }

    static void dfs(int a, int b, int depth, int start, String[] str) {
        if (depth == a) {
            boolean check = false;
            int one = 0;
            int two = 0;

            for (String s : map) {
                if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
                    one++;
                } else two++;
            }

            if (one >= 1 && two >= 2) check = true;

            if (check) {
                for (String s : map) {
                    sb.append(s);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < b; i++) {
            if (!visited[i]) {
                visited[i] = true;
                map[depth] = str[i];
                dfs(a, b, depth + 1, i, str);
                visited[i] = false;
            }
        }
    }
}
