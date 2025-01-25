package softeer.level2;
import java.io.*;
import java.util.*;


public class lv2_8단변속기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] up = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int[] down = new int[] {8, 7, 6, 5, 4, 3, 2, 1};

        boolean upCheck = true;
        boolean downCheck = true;

        for(int i = 0; i < 8; i++) {
            if(arr[i] != up[i]) {
                upCheck = false;
            }
            if (arr[i] != down[i]) {
                downCheck = false;
            }
        }

        if(upCheck) {
            System.out.println("ascending");
        } else if(downCheck) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
