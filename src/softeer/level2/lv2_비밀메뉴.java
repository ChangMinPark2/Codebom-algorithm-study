package softeer.level2;
import java.io.*;
import java.util.*;
/**
 1부터 k개의 버튼이 존재.
 메뉴 조작법은 M개의 버튼
 사용자가 누른 N개의 버튼 조작이 주어질 때?

 **/

public class lv2_비밀메뉴 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        String secret = br.readLine().replace(" ", "");
        String user = br.readLine().replace(" ", "");

        if(user.contains(secret)) {
            System.out.println("secret");
            return;
        }

        System.out.println("normal");
    }
}
