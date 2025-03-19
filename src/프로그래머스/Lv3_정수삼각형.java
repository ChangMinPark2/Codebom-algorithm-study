package 프로그래머스;

public class Lv3_정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (i == j) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] = Math.max(triangle[i - 1][j], triangle[i - 1][j - 1])
                            + triangle[i][j];
                }

                answer = Math.max(answer, triangle[i][j]);
            }
        }

        return answer;
    }

}
