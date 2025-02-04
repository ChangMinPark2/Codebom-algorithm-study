package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_16926_Re {
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

        for (int i = 0; i < r; i++) { //회전 수
            for (int j = 0; j < line; j++) { //기준 선
                //반시계 시작
                int tem = arr[j][j];

                //1
                for (int z = j + 1; z < m - j; z++) {
                    arr[j][z - 1] = arr[j][z];
                }
                //2
                for (int z = j + 1; z < n - j; z++) {
                    arr[z - 1][m - 1 - j] = arr[z][m - 1 - j];
                }
                //3
                for (int z = m - 2 - j; z >= j; z--) {
                    arr[n - 1 - j][z + 1] = arr[n - 1 - j][z];
                }
                //4
                for (int z = n - 2 - j; z >= j; z--) {
                    arr[z + 1][j] = arr[z][j];
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
