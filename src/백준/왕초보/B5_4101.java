package 백준.왕초보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5_4101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] repo = br.readLine().split(" ");
            long a = Long.parseLong(repo[0]);
            long b = Long.parseLong(repo[1]);

            if (a == 0 && b == 0) {
                break;
            }

            System.out.println(a > b ? "Yes" : "No");
        }

    }
}
