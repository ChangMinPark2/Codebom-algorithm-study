package 프로그래머스_4장_문자열;

/**
 * 1. s의 0의 개수를 지운다.
 * 2. 지운 s를 이진수로 변환한다.
 * 3. 이 과정을 s가 1이 될 때 까지 반복한 후 return ( 총 변환 횟수, 지워진 0의 개수);
 */
public class 이진변환반복하기_Level1 {
    public int[] solution(String s) {
        int zeroIndex = 0;
        int oneIndex = 0;

        while (!s.equals("1")) {
            int oneCount = count(s);
            oneIndex += oneCount;
            zeroIndex++;

            int removedLength = s.length() - oneCount;
            s = Integer.toString(removedLength, 2);
        }
        return new int[] {zeroIndex, oneIndex};
    }

    private int count(String s) {
        return (int) s.chars()
                .filter(c -> c == '0')
                .count();
    }
}
