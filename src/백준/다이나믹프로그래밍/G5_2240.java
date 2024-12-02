package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        int time = Integer.parseInt(repo[0]);
        int stand = Integer.parseInt(repo[1]);
        int[] arr = new int[time + 1];

        for (int i = 1; i <= time; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][][] mem = new int[3][time + 1][stand + 2]; // 현재 위치, 시간, 이동횟

        for (int i = 1; i <= time; i++) {
            for (int j = 1; j <= stand + 1; j++) {
                if (arr[i] == 1) {
                    mem[1][i][j] = Math.max(mem[1][i - 1][j], mem[2][i - 1][j - 1]) + 1;
                    mem[2][i][j] = Math.max(mem[2][i - 1][j], mem[1][i - 1][j - 1]);
                } else {
                    if (i == 1 && j == 1) continue;
                    mem[1][i][j] = Math.max(mem[1][i - 1][j], mem[2][i - 1][j - 1]);
                    mem[2][i][j] = Math.max(mem[2][i - 1][j], mem[1][i - 1][j - 1]) + 1;
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= stand+ 1; i++) {
            answer = Math.max(answer, Math.max(mem[1][time][i], mem[2][time][i]));
        }

        System.out.println(answer);
    }
}
