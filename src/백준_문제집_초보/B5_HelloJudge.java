package 백준_문제집_초보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5_HelloJudge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());


        for (int i = 1; i <= a; i++) {
            System.out.println("Hello World, Judge " + i + "!");
        }

    }
}
