package 프로그래머스_6장_완전탐색;

/**
 <문제풀이흐름>
 갈색 격자의 수는 2(width + height - 2)이다.
 노란 격자의 수는 넓이 - 갈색 격자의 수 이다.
 노란 격자의 개수는 1이상이다. 최소 3 이상이라는 것을 의미한다.
 갈색 격자의 개수는 5000이하이다.
 **/
public class 카펫 {
    public int[] solution(int brown, int yellow) {
        for(int width = 3; width <= 5000; width++) {
            for(int height = 3; height <= width; height ++) {
                int a = (width + height - 2) * 2;
                int b = width * height - a;

                if(brown == a && yellow == b) {
                    return new int[] {width, height};
                }
            }
        }

        return null;
    }
}
