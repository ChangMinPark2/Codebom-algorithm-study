package softeer.level2;
import java.io.*;
import java.util.*;


public class lv2_지도자동구축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] mem = new int[16];
        mem[0] = 2;
        mem[1] = 3;

        for(int i = 2; i <= n; i++) {
            mem[i] = mem[i - 1] * 2 - 1;
        }

        System.out.println((int)Math.pow(mem[n], 2));
    }
}
