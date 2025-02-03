package softeer.level2;

import java.io.*;
import java.util.*;

public class lv2_바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        long k = Long.parseLong(temp[0]);
        long p = Long.parseLong(temp[1]);
        long n = Long.parseLong(temp[2]);
        long result = k;

        for(int i = 1; i <= n; i++) {
            result = (result * p) % 1000000007;
        }

        System.out.println(result);
    }
}
