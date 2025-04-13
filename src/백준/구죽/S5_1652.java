package 백준.구죽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S5_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] str = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");

            for (int j = 0; j < n; j++) {
                str[i][j] = temp[j];
            }
        }

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (str[i][j].equals(".") && str[i][j + 1].equals(".")) {
                    x++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (str[j][i].equals(".") && str[j + 1][i].equals(".")) {
                    y++;
                    break;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}
