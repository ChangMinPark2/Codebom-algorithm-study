package 코드봄.디피;

import java.util.*;

public class Level3_등굣길 {
    static int[][] mem = new int[101][101];
    public int solution(int m, int n, int[][] puddles) {
        for(int[] temp : mem) {
            Arrays.fill(temp, -1);
        }

        boolean[][] isPuddle = new boolean[n + 1][m + 1];

        for(int[] temp : puddles) {
            isPuddle[temp[1]][temp[0]] = true;
        }

        return count(1, 1, m, n, isPuddle);
    }

    private int count(int x, int y, int w, int h, boolean[][] isPuddle) {
        if(x > w || y > h) return 0;
        if(isPuddle[y][x]) return 0;

        if(mem[x][y] != -1) return mem[x][y];
        if(x == w && y == h) return 1;

        int total = count(x + 1, y, w, h, isPuddle) + count(x, y + 1, w, h, isPuddle);
        return mem[x][y] = total % 1000000007;
    }
}
