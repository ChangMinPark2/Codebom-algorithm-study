package k디지털알고리즘;
import java.io.*;
import java.util.Arrays;
/**
 DP 이용. 십만까지 이므로, 스택 오버플로우 발생. 0부터 시작
 **/
public class 피보나치 {
    private static int[] mem = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Arrays.fill(mem, -1);
        int n = Integer.parseInt(input);

        for(int i = 0; i <= n; i++){
            fib(i);
        }

        System.out.println(fib(n));

    }

    private static int fib (int n) {
        if(mem[n] != -1) return mem[n];

        if(n == 1 || n == 0) return n;

        return mem[n] = (fib(n - 1) + fib(n - 2)) % 1000000007;
    }
}
