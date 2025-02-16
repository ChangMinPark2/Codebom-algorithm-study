package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B1_1157_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cr = br.readLine().toUpperCase().toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : cr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int stand = -1;
        char c = ' ';

        for (char key : map.keySet()) {
            if (map.get(key) > stand) {
                stand = map.get(key);
                c = key;
            } else if (map.get(key) == stand) {
                c = '?';
            }
        }

        System.out.println(c);
    }
}
