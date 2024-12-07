package PCCP;

import java.util.*;

public class 기출문제_2_석유시추 {
    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {1, -1, 0, 0};

    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] mem = new int[m];

        for(int i = 0; i < land[0].length; i++) { //x축 부터 접근
            for(int j = 0; j < land.length; j++) { //y축
                if(!visited[j][i] && land[j][i] == 1) {
                    bfs(land, j, i, visited, mem);
                }
            }
        }

        for (int i : mem) {
            answer = Math.max(answer, i);
        }

        return answer;
    }

    private void bfs(int[][] land, int y, int x, boolean[][] visited, int[] mem) {
        visited[y][x] = true;
        Queue<int[]> q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        q.add(new int[] {y, x});
        int size = 1;

        while(!q.isEmpty()) {
            int[] temp = q.remove();
            int a = temp[0];
            int b = temp[1]; //y축
            set.add(b);

            for(int i = 0; i < 4; i++) {
                int oy = a + dy[i];
                int ox = b + dx[i];

                if(isCheck(oy, ox, land) && !visited[oy][ox] && land[oy][ox] == 1) {
                    visited[oy][ox] = true;
                    q.add(new int[] {oy, ox});
                    size++;
                }
            }
        }

        for (int i : set) {
            mem[i] += size;
        }
    }

    private boolean isCheck(int y, int x, int[][] arr) {
        return y >= 0 && y < arr.length && x >= 0 && x < arr[0].length;
    }
}
