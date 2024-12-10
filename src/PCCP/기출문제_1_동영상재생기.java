package PCCP;

public class 기출문제_1_동영상재생기 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int length = secondTranslater(video_len);
        int start = secondTranslater(pos);
        int openStart = secondTranslater(op_start);
        int openEnd = secondTranslater(op_end);

        for(String s : commands) {
            if(openStart <= start && start <= openEnd) {
                start = openEnd;
            }

            if(s.equals("next")) {
                if(start + 10 > length) {
                    start = length;
                } else {
                    start += 10;
                }
            } else {
                if(start - 10 < 0) {
                    start = 0;
                } else {
                    start -= 10;
                }
            }

            if(openStart < start && start < openEnd) {
                start = openEnd;
            }
        }
        return String.format("%02d:%02d", start / 60, start % 60);
    }

    private int secondTranslater(String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}
