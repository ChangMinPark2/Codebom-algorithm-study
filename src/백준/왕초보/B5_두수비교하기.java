package 백준.왕초보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5_두수비교하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        int a = Integer.parseInt(repo[0]);
        int b = Integer.parseInt(repo[1]);

        if (a > b) {
            System.out.println(">");
        } else if (a < b) {
            System.out.println("<");
        } else  {
            System.out.println("==");
        }
    }
}
