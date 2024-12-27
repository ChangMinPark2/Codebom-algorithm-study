package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * n <= 10만, (정렬, 이분탐색)
 *
 * n줄에, 0이상 9이하의 숫자가 3개씩 적혀있다.
 * 이 게임은 첫 줄에서 시작해서 마지막 줄에서 끝나게 되는 놀이
 * 처음에 적혀있는 세개의 숫자 중에서 하나를 골라 시작한다.
 * 다음 줄로 내려가는데, 다음 줄로 내려갈 때는 조건이 있음.
 * 바로 아래의 수, 바로 아래의 수와 붙어있는 수로만 이동 가능하다.
 * 1 2 3
 * (6) (8) (9)
 * 4 + 9, 9 + 9, 0 + 9
 * 누적합 하면 될듯? dp
 */
public class G5_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] maxMem = new int[n + 1][3];
        int[][] minMem = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            String[] repo = br.readLine().split(" ");

            maxMem[i][0] = Math.max(maxMem[i - 1][0], maxMem[i - 1][1]) + Integer.parseInt(repo[0]);
            maxMem[i][1] = Math.max(maxMem[i - 1][0], Math.max(maxMem[i - 1][1], maxMem[i - 1][2])) + Integer.parseInt(repo[1]);
            maxMem[i][2] = Math.max(maxMem[i - 1][1], maxMem[i - 1][2]) + Integer.parseInt(repo[2]);

            minMem[i][0] = Math.min(minMem[i - 1][0], minMem[i - 1][1]) + Integer.parseInt(repo[0]);
            minMem[i][1] = Math.min(minMem[i - 1][0], Math.min(minMem[i - 1][1], minMem[i - 1][2])) + Integer.parseInt(repo[1]);
            minMem[i][2] = Math.min(minMem[i - 1][1], minMem[i - 1][2]) + Integer.parseInt(repo[2]);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            max = Math.max(maxMem[n][i], max);
            min = Math.min(minMem[n][i], min);
        }

        System.out.println(max + " " + min);
    }
}
