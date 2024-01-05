package 프로그래머스_4장_문자열;

public class 이상한문자만들기_Level1 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean zero = true;

        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                sb.append(c);
                zero = true;

            } else {
                if (zero) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                zero = !zero;
            }
        }
        return sb.toString();
    }

    public String solution2(String s) {

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        String[] array = s.split("");

        for (String ss : array) {
            cnt = ss.equals(" ")? 0 : cnt + 1;

            sb.append(cnt % 2 == 0 ? ss.toLowerCase() : ss.toUpperCase());
        }
        return sb.toString();
    }


}
