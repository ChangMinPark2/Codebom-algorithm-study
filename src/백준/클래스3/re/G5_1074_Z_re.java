package 백준.클래스3.re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2의 15승 이면 대충 3만? (애매)
 * N이 주어질 때, R행과, C열을 몇 번째로 방문하는지 출력하시오.
 * Z의 순서 -> 2사, 1사, 3사, 4사
 */
public class G5_1074_Z_re {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

        int n = Integer.parseInt(repo[0]);
        int r = Integer.parseInt(repo[1]);
        int c = Integer.parseInt(repo[2]);

        int size = (int) Math.pow(2, n); //한 변의 사이즈
        partition(r, c, size);

    }

    private static void partition(int y, int x, int size) {
        //종료조건
        if (size == 1) {
            System.out.println(answer);
            return;
        }

        int stand = size / 2; // 4

        if (y < stand && x < stand) { //2사
            partition(y, x, stand);
        } else if (y < stand && x >= stand) { //1사
            answer += size * size / 4;
            partition(y, x - stand, stand);
        } else if (y >= stand && x < stand) { //3사
            answer += (size * size / 4) * 2;
            partition(y - stand, x, stand);
        } else {
            answer += (size * size / 4) * 3;
            partition(y - stand, x - stand, stand);
        }
    }
}
