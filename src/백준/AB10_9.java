package 백준;
import java.io.*;
public class AB10_9 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        System.out.println(Double.parseDouble(repo[0])/ Double.parseDouble(repo[1]));
    }
}
