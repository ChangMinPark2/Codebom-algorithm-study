package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_11404_플로이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int INF = 987654321;
        int[][] arr = new int[n + 1][n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = INF;

                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);

            arr[a][b] = Math.min(arr[a][b], c);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int z = 1; z <= n; z++) {
                    if (arr[j][z] > arr[j][i] + arr[i][z]) {
                        arr[j][z] = arr[j][i] + arr[i][z];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == INF) {
                    arr[i][j] = 0;
                }

                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
