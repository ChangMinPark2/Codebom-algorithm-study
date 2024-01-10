package 프로그래머스_7장_정렬;

/**
 * 코스요리 메뉴는 최소 2가지 이상의 만품메뉴로 구성
 * 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
 **/
public class 메뉴리뉴얼_level2 {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        return answer;
    }

    private static class Course {
        public final String course;
        public final int occurrences;

        public Course(String course, int occurrences) {
            this.course = course;
            this.occurrences = occurrences;
        } 
    }
}


