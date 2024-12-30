package 프로그래머스;

/**
 n이 6만. 정렬?

 n: 1 -> 1
 n: 2 -> 2
 n: 3 -> 3
 n: 4 -> 5

 **/

public class Lv2_2xn타일링 {
    public int solution(int n) {
        int[] mem = new int[n + 1];
        mem[1] = 1;
        mem[2] = 2;

        for(int i = 3; i <= n; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2]) % 1000000007;
        }

        return mem[n];
    }
}
