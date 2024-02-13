package 백준.그리디;
/*
5, 2원을 가지고 있음.
거스름돈 % 5 == 0 이 종료조건
% 5 가 될 때 까지 -= 2;
0보다 작으면 -1;

 */
import java.io.*;
public class S5_거스름돈 {
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (true) {
            if (n % 5 == 0) {
                count += n / 5;
                break;
            } else {
                n -= 2;
                count++;
            }

            if (n < 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(count);
    }
}
