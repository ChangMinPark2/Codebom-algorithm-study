package 백준.그리디;
import java.io.*;

public class S4_설탕배달 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while (true) {
            if (n % 5 == 0) {
                count += n / 5;
                System.out.println(count);
                break;
            } else {
                n -= 3;
                count++;
            }

            if (n < 0) {
                System.out.println(-1);
                break;
            }
        }
    }
}
