package 프로그래머스_10장_동적프로그래밍;

import java.util.Arrays;

/**
 <문제풀이흐름>
 n의 최대: 10만, 재귀의 깊이가 1만이 넘어가면 StackOverflowError가 뜨므로 일반 재귀는 불가.
 동적 프로그래밍 이용 -> 애도 첫 시작이 십만이기 때문에, StackOverFlow가 남.
 < 작은 부분 문제부터 해결하기 >
 **/
public class 피보나치수_Level2 {
    private static int[] mem = new int[100001];

    public static int solution(int n) {

        Arrays.fill(mem, -1);

        for(int i = 0; i <= n; i++) {
            fib(i);
        }
        return fib(n);
    }

    private static int fib(int n) {
        if(mem[n] != -1) return mem[n];
        if(n == 1 || n == 0) {
            return n;
        }

        return mem[n] = (fib(n-1) + fib(n-2)) % 1234567;
    }

    public static void main(String[] args) {
        System.out.println(solution(100000));
    }
}
