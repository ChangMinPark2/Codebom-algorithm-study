package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_16926_배열돌리기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int r = Integer.parseInt(temp[2]);
        int line = Math.min(n, m) / 2;

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < line; j++) {
                int tem = arr[j][j];

                // 1. 오른쪽상단 -> 왼쪽상단
                for (int k = j + 1; k < m - j; k++) {
                    arr[j][k - 1] = arr[j][k];
                }
                // 2. 오른쪽하단 -> 오른쪽상단
                for (int k = j + 1; k < n - j; k++) {
                    arr[k - 1][m - j - 1] = arr[k][m - j - 1];
                }
                // 3. 왼쪽하단 -> 오른쪽하단
                for (int k = m - 2 - j; k >= j; k--) {
                    arr[n - 1 - j][k + 1] = arr[n - 1 - j][k];
                }
                // 4. 왼쪽상단 -> 왼쪽하단
                for (int k = n - j - 2; k >= j; k--) {
                    arr[k + 1][j] = arr[k][j];
                }

                arr[j + 1][j] = tem;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int[] ar : arr) {
            for (int a : ar) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
