package 백준.클래스3.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_2630_re {
    static int[][] arr;
    static int n;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        partition(0, 0, n);
        System.out.println(white + "\n" + blue);

    }

    private static void partition(int y, int x, int size) {

        if (isCheck(y, x, size)) {
            if (arr[y][x] == 1) {
                blue++;
            } else white++;

            return;
        }

        int newSize = size / 2;

        //1사
        partition(y, x + newSize, newSize);
        //2사
        partition(y, x, newSize);
        //3사
        partition(y + newSize, x, newSize);
        //4사
        partition(y + newSize, x + newSize, newSize);
    }

    private static boolean isCheck(int y, int x, int size) {
        int stand = arr[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (stand != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
