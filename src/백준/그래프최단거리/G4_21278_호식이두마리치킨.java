package 백준.그래프최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_21278_호식이두마리치킨 {
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
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                mem[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            mem[a][b] = mem[b][a] = 1;
        }

        floyd();
        System.out.println(calculator());
    }

    private static String calculator() {
        int answer = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int total = 0;

                for (int k = 1; k <= n; k++) {
                    if (k == i || k == j) continue;

                    int min = Math.min(mem[k][i], mem[k][j]);
                    total += min;
                }

                if (total < answer) {
                    answer = total;
                    a = i;
                    b = j;
                }
            }
        }

        return String.format("%d %d %d", a, b, answer * 2);
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
