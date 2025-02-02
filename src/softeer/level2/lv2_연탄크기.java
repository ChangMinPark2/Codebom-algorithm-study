package softeer.level2;
import java.io.*;
import java.util.*;

public class lv2_연탄크기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] mem = new int[101];

        for(int i = 2; i < 101; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[j] % i == 0) {
                    mem[i]++;
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int i : mem) {
            answer = Math.max(answer, i);
        }

        System.out.println(answer);
    }
}
