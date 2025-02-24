package 백준.클래스4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_2448_별찍기24 {

    public static void main(String[] args) throws IOException{
        int[] arr = new int[101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            for (int i = 0; i <= n; i++) {
                arr[i]++;
            }

            System.out.println(arr[n]);
        }

    }
}


