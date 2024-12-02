package 백준.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class G4_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] mem = new int[n];
        Arrays.fill(mem, 1);
        int lis = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
            lis = Math.max(mem[i], lis);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis).append("\n");

        Deque<Integer> s = new ArrayDeque<>();

        for (int i = n-1; i>= 0; i--) {
            if (mem[i] == lis) {
                s.push(arr[i]);
                lis--;
            }
        }

        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
