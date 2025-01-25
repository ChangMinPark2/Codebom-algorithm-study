package softeer.level3;
import java.io.*;

public class lv3_성적평균 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[] mem = new int[n + 1];
        temp = br.readLine().split(" ");

        for(int i = 1; i <= n; i++) {
            mem[i] = mem[i - 1] + Integer.parseInt(temp[i - 1]);
        }

        for(int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            sb.append(calculator(mem[a - 1], mem[b], b - a + 1)).append("\n");
        }

        System.out.println(sb);
    }

    private static String calculator(int a, int b, int stand) {
        double da = a;
        double db = b;

        return String.format("%.2f", (db - da) / stand);
    }
}
