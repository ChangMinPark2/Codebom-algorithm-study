package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N의 최대값 128 -> 완탐 가능할듯 ?
 * 하얀색 -> 0, 파란색 -> 1
 */

public class S2_2630_색종이만들기 {
    private static int white = 0;
    private static int blue = 0;
    private static int[][] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        square = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] repo = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                square[i][j] = Integer.parseInt(repo[j]);
            }
        }

        partition(0, 0, n);
        System.out.println(white + "\n" + blue);
    }

    private static void partition(int y, int x, int size) {
        if (colorCheck(y, x, size)) {
            if (square[y][x] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        partition(y, x, newSize);  //2
        partition(y, x + newSize, newSize); //1
        partition(y + newSize, x, newSize); //3
        partition(y + newSize, x + newSize, newSize); //4
    }

    private static boolean colorCheck(int y, int x, int size) {
        int color = square[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (square[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
