package 코드봄.완전탐색;

/**
 * <문제 풀이 흐름>
 * 갈색 격자와 노란색 격자를 이용해 가로와 세로를 구하는 문제이다.
 * 갈색 격자는 테두리이고, 노란색 격자는 안쪽에 있는 격자들이다.
 * 갈색격자는 최솟값 8 노란색 격자 최솟값 1 -> 가로, 세로의 최솟값은 3
 * 가로의 길이는 세로보다 길거나 같다. -> 세로는 가로까지.
 *
 */
public class 카펫 {
    public int[] solution(int brown, int yellow) {
       for (int x = 3; x < brown; x++) {
           for (int y = 3; y <=x; y++) {
               int repoB = (x + y - 2) * 2;
               int repoY = (x * y) - brown;

               if (repoB == brown && repoY == yellow){
                   return new int[] {x, y};
               }
           }
       }
       return null;
    }
}
