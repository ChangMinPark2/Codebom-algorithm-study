package 백준.그래프최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_2660_회장뽑기 {
    private static final int INF = 1000000000;
    static int n;
    static int[][] mem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mem = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;

                mem[i][j] = INF;
            }
        }

        while (true) {
            String[] temp = br.readLine().split(" ");

            if (temp[0].equals("-1")) {
                break;
            }

            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            mem[a][b] = mem[b][a] = 1;
        }

        floyd();

        int stand = INF;
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int score = 0;

            for (int j = 1; j <= n; j++) {
                if (mem[i][j] != INF) {
                    score = Math.max(score, mem[i][j]);
                }
            }

            arr[i] = score;
            stand = Math.min(stand, score);
        }

        StringBuilder up = new StringBuilder();
        StringBuilder down = new StringBuilder();

        up.append(stand).append(" ");

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (arr[i] == stand) {
                count++;
                down.append(i).append(" ");
            }
        }
        up.append(count);

        System.out.println(up);
        System.out.println(down);

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
