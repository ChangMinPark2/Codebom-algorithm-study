package 프로그래머스_4장_문자열;

import java.util.*;
/**
 <문제 풀이 흐름>
 1. 1부터 입력 문자열 s의 길이만큼 자를 문자열의 길이를 설정하여 반복한다.
 2. 설정된 길이만큼 문자열을 잘라 낸 token의 배열을 생성한다.
 3. 문자열을 비교하며 token의 배열을 하나의 문자열로 압축한다.
 4. 1~3 과정을 통해 압축된 문자열 중 가장 짧은 길이 반환한다.
 testcase : 5
 **/
public class 문자열압축_Level2_kakao {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < s.length(); i++) {
            int compressed = compress(s, i);

            if (compressed < min) {
                min = compressed;
            }
        }
        return min;
    }


    //문자열을 압축하여 압축된 길이를 리턴해주는 함수
    private int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();
        String last = "";
        int count = 0;

        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count++;
            } else {
                if (count > 1) sb.append(count);
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        if (count > 1) {
            sb.append(count);
        }
        sb.append(last);

        return sb.length();
    }


    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();

        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;

            if (endIndex > source.length()) endIndex = source.length();

            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }
}
