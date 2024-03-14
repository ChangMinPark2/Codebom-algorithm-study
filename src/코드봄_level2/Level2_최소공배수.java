package 코드봄_level2;
import java.util.*;

public class Level2_최소공배수 {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        for (int i=0; i<arr.length-1; i++) {
            int num = max(arr[i+1], arr[i]);
            arr[i+1] = (arr[i] * arr[i+1]) / num;

        }
        return arr[arr.length-1];
    }

    private static int max (int a, int b) {
        if(a % b == 0) return b;
        return max (b, (a % b));
    }

    public static void main(String[] args) {
        System.out.println(7 % 2);
        System.out.println(max(2, 7));
    }
}
