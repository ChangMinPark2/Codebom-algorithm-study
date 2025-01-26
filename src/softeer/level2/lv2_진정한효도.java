package softeer.level2;

import java.io.*;
import java.util.*;

public class lv2_진정한효도 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[3][3];

        for(int i = 0; i < 3; i++) {
            String[] temp = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(temp[0]);
            arr[i][1] = Integer.parseInt(temp[1]);
            arr[i][2] = Integer.parseInt(temp[2]);
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++) {
            //가로
            int aMax = Math.max(arr[i][0], Math.max(arr[i][1], arr[i][2]));
            int aMin = Math.min(arr[i][0], Math.min(arr[i][1], arr[i][2]));
            answer = Math.min(answer, aMax - aMin);

            //세로
            int bMax = Math.max(arr[0][i], Math.max(arr[1][i], arr[2][i]));
            int bMin = Math.min(arr[0][i], Math.min(arr[1][i], arr[2][i]));
            answer = Math.min(answer, bMax - bMin);

            if(answer == 0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(answer);
    }
}
