package 프로그래머스_4장_문자열;

//ab,1 -> bc 출력
public class 시저암호_Level1 {
    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (char c: s.toCharArray()){
            sb.append(push(c,n));
        }
        return new String(sb);
    }

    //a = 0, b = 1, z = 25
    private static char push(char c, int n){
        if (!Character.isAlphabetic(c)) return c;

        int standard = Character.isUpperCase(c) ? 'A' : 'a'; //기준점을 잡아주기 위해서
        int number = c - standard; // char c의 int 값.

        int answer = (number + n) % ('z' - 'a' + 1);//Z 다음 다시 알파벳으로 넘어가는 것을 방지.
        return (char) (answer + standard); // 다시 알파벳으로 구하기 위해 what 기준점 더하기
    }
    public static void main(String[] args) {
        System.out.println(solution("d", 1));
    }
}
