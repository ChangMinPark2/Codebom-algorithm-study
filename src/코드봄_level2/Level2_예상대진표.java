package 코드봄_level2;

public class Level2_예상대진표 {
    public int solution(int n, int a, int b) {
        int count = 0;

        while (a != b) {
            a = (a - 1) / 2 + 1;
            b = (b - 1) / 2 + 1;

            count++;
        }
        return count;
    }
}
