package 프로그래머스;
/**
 zero -> s - 0의 갯수
 one -> 이진 변환. s가 1이라면 종료.
 **/
public class 이진변환반복하기 {
    public int[] solution(String s) {
        int one = 0;
        int zero = 0;

        while(!s.equals("1")) {
            int repo = zeroCount(s);
            one += repo;
            s = Integer.toString(s.length() - repo, 2);
            zero++;
        }

        return new int[] {zero, one};
    }

    private int zeroCount(String s) {
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '0') count++;
        }
        return count;
    }
}
