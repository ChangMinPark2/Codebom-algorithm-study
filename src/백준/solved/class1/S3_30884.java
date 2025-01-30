package 백준.solved.class1;
import java.io.*;
import java.util.*;

public class S3_30884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length - 1; i++) {
            sb.append(s[i]);

            if(s[i] == '(' && s[i + 1] == ')') {
                sb.append(1);
            }
            if(s[i] == ')' && s[i + 1] == '(') {
                sb.append("+");
            }
        }
        sb.append(s[s.length - 1]);

        System.out.println(sb);
    }
}
