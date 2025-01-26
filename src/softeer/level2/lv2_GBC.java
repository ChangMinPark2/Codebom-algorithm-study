package softeer.level2;
import java.io.*;
import java.util.*;

public class lv2_GBC {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        int[] elevator = new int[101];
        int[] gwang = new int[101];

        int stand = 0;

        for(int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");

            for(int j = stand + 1; j <= stand + Integer.parseInt(temp[0]); j++) {
                elevator[j] = Integer.parseInt(temp[1]);
            }
            stand += Integer.parseInt(temp[0]);
        }

        stand = 0;

        for(int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");

            for(int j = stand + 1; j <= stand + Integer.parseInt(temp[0]); j++) {
                gwang[j] = Integer.parseInt(temp[1]);
            }
            stand += Integer.parseInt(temp[0]);
        }

        int answer = Integer.MIN_VALUE;

        for(int i = 1; i <= 100; i++) {
            int difference = gwang[i] - elevator[i];

            if(difference < 0) difference = 0;

            answer = Math.max(answer, difference);
        }

        System.out.println(answer);
    }
}
