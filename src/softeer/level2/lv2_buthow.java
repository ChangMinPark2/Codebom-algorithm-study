package softeer.level2;

import java.io.*;
import java.util.*;

public class lv2_buthow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.replace("()", "(1)");
        s = s.replace(")(", ")+(");
        System.out.println(s);
    }
}
