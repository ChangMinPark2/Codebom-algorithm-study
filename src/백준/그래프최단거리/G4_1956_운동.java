package 백준.그래프최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G4_1956_운동 {
    private static final int INF = 1000000000;
    static int n, m;
    static int[][] mem;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        mem = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n; j++){
                if (i == j) continue;
                mem[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int cost = Integer.parseInt(temp[2]);

            mem[a][b] = cost;
        }

        floyd();

        int answer = INF;

        boolean check = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && mem[i][j] != INF && mem[j][i] != INF) { //자기자신, 못가는 경로를 제외
                    answer = Math.min(mem[i][j] + mem[j][i], answer);
                    check = true;
                }
            }
        }

        System.out.println(check ? answer : -1);
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    mem[i][j] = Math.min(mem[i][j], mem[i][k] + mem[k][j]);
                }
            }
        }
    }
}
