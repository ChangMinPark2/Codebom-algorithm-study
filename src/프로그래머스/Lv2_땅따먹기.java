package 프로그래머스;

public class Lv2_땅따먹기 {
    int solution(int[][] land) {
        int[][] mem = new int[land.length][4];
        mem[0][0] = land[0][0];
        mem[0][1] = land[0][1];
        mem[0][2] = land[0][2];
        mem[0][3] = land[0][3];

        for(int i = 1; i < land.length; i++) {
            mem[i][0] = Math.max(mem[i - 1][1], Math.max(mem[i - 1][2], mem[i - 1][3])) + land[i][0];
            mem[i][1] = Math.max(mem[i - 1][0], Math.max(mem[i - 1][2], mem[i - 1][3])) + land[i][1];
            mem[i][2] = Math.max(mem[i - 1][1], Math.max(mem[i - 1][3], mem[i - 1][0])) + land[i][2];
            mem[i][3] = Math.max(mem[i - 1][1], Math.max(mem[i - 1][2], mem[i - 1][0])) + land[i][3];
        }

        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, mem[land.length - 1][i]);
        }

        return answer;
    }
}
