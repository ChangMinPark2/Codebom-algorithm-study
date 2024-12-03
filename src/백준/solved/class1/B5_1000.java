package 백준.solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5_1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        System.out.println(Integer.parseInt(repo[0]) + Integer.parseInt(repo[1]));
    }
}
