package softeer.level2;

import java.io.*;
import java.util.*;

public class Lv2_금고털이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int w = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);
        int answer = 0;
        Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");

            map.put(Integer.parseInt(temp[1]), map.getOrDefault(Integer.parseInt(temp[1]), 0) + Integer.parseInt(temp[0]));
        }

        for (int key : map.keySet()) {
            if (w - map.get(key) >= 0) { //양수라면
                answer += key * map.get(key);
                w -= map.get(key);
            } else { //30만큼 더한다
                answer += w * key;
                break;
            }
        }

        System.out.println(answer);
    }
}
