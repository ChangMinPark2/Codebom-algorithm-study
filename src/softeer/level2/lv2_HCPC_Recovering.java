package softeer.level2;
import java.io.*;

public class lv2_HCPC_Recovering {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");

            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
