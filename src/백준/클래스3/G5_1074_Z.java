package 백준.클래스3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N이 15, r:행, c:열
 * 2의 15승, 3만 2천
 */
public class G5_1074_Z {
    static int answer = 0;
    static int N, R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");
        N = Integer.parseInt(repo[0]);
        R = Integer.parseInt(repo[1]);
        C = Integer.parseInt(repo[2]);
        partition(0, 0, (int)Math.pow(2, N));
    }

    private static void partition(int r, int c, int size) {
        if (size == 1) {
            System.out.println(answer);
            return;
        }

        int newSize = size / 2;

        if (R < r + newSize && C < c + newSize) {
            partition(r, c, newSize);
        } else if (R < r + newSize && c + newSize <= C) {
            answer += (size * size) / 4;
            partition(r, c + newSize, newSize);
        } else if (r + newSize <= R && C < c + newSize) {
            answer += ((size * size) / 4) * 2;
            partition(r + newSize, c, newSize);;
        } else if (r + newSize <= R && c + newSize <= C) {
            answer += ((size * size) / 4) * 3;
            partition(r + newSize, c + newSize, newSize);
        }
    }
}
