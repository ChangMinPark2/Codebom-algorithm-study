package softeer.level2;

import java.io.*;
import java.util.*;

public class Lv2_XmarkTheSports {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");

            for(int j = 0; j < temp[0].length(); j++) {
                if(temp[0].charAt(j) == 'x' || temp[0].charAt(j) == 'X') {
                    sb.append(temp[1].charAt(j));
                    break;
                }
            }
        }

        String answer = sb.toString().toUpperCase();
        System.out.println(answer);
    }
}
