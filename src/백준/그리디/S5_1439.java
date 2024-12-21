package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * n -> 100만
 * O(N)으로 해결 정렬 X
 *
 */
public class S5_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st1 = new StringTokenizer(s, "0");
        StringTokenizer st2 = new StringTokenizer(s, "1");
        System.out.println(Math.min(st1.countTokens(), st2.countTokens()));
    }
}
