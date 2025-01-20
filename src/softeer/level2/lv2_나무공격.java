package softeer.level2;
import java.util.*;
import java.io.*;

public class lv2_나무공격 {
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        arr = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            String[] repo = br.readLine().split(" ");

            for(int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(repo[j - 1]);
            }
        }

        for(int i = 0; i < 2; i++) {
            String[] repo = br.readLine().split(" ");

            int a = Integer.parseInt(repo[0]);
            int b = Integer.parseInt(repo[1]);

            for(int j = a; j <= b; j++) {
                for(int z = 1; z <= m; z++) {
                    if(arr[j][z] == 1) {
                        arr[j][z] = 0;
                        break;
                    }
                }
            }
        }

        System.out.println(caculator());
    }

    private static int caculator() {
        int sum = 0;

        for (int[] ar : arr) {
            for(int a : ar) {
                if (a == 1) {
                    sum++;
                }
            }
        }

        return sum;
    }
}
