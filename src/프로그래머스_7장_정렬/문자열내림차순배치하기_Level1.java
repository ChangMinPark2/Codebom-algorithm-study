package 프로그래머스_7장_정렬;

public class 문자열내림차순배치하기_Level1 {
    public String solution(String s) {
        return s.chars()
                .boxed()
                .sorted((s1, s2) -> s2 - s1)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }
}
