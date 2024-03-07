package 코드봄.디피;

import java.util.Arrays;

public class Level3_정수삼각형 {
    int[][] mem = new int[501][501];
    public int solution(int[][] triangle) {
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return max(0, 0, triangle);
    }

    private int max(int x, int y, int[][] triangle) {
        if (y == triangle.length) return 0;
        if (mem[y][x] != -1) return mem[y][x];

        return mem[y][x] = triangle[y][x] + Math.max(
                max(x, y + 1, triangle),
                max(x + 1, y + 1, triangle));
    }
}
