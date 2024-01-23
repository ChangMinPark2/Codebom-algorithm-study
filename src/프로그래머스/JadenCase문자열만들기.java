package 프로그래머스;

public class JadenCase문자열만들기 {
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        upper(s.charAt(0), sb);

        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i - 1) == ' ') {
                upper(s.charAt(i), sb);
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
    private void upper(char c, StringBuilder sb) {
        sb.append(Character.toUpperCase(c));
    }
}
