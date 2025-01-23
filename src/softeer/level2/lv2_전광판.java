package softeer.level2;
import java.util.*;
import java.io.*;

public class lv2_전광판 {
    static Map<Character, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map.put(' ', "0000000");
        map.put('0', "1110111");
        map.put('1', "0010001");
        map.put('2', "0111110");
        map.put('3', "0111011");
        map.put('4', "1011001");
        map.put('5', "1101011");
        map.put('6', "1101111");
        map.put('7', "1110001");
        map.put('8', "1111111");
        map.put('9', "1111011");

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            String a = String.format("%5s", temp[0]);
            String b = String.format("%5s", temp[1]);

            calculator(a, b);
        }

        System.out.println(sb);
    }

    private static void calculator(String a, String b) {
        char[] oa = a.toCharArray();
        char[] ob = b.toCharArray();

        int count = 0;

        for(int i = 0; i < 5; i++) {
            char[] before = map.get(oa[i]).toCharArray(); //0
            char[] after = map.get(ob[i]).toCharArray(); //1

            for(int j = 0; j < before.length; j++) {
                if(before[j] != after[j]) {
                    count++;
                }
            }
        }

        sb.append(count).append("\n");
    }
}
