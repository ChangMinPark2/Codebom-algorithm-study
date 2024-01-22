package 프로그래머스_12장_구현;

/**
 <문제 풀이 흐름>
 배열 안의 스킬들이 스킬트리 순서대로 찍었는가를 체크하는 문제.
 다른 스킬을 배워도 상관 없지만 skill에는 선행스킬은 맞아야한다.
 스킬트리가 아닌 스킬은 전부 없에준다. replaceAll
 이후 1부터 시작해 반복문을 돌려 전 인덱스랑 같은지 체크해준다. // 확인하지 못한다.
 StartsWith 이용
 **/
public class 스킬트리_Level2 {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        for(String s : skill_trees) {
            if(isSkill(skill, s)) count++;
        }

        return count;
    }

    private boolean isSkill (String skill, String checkSkill) {
        checkSkill = checkSkill.replaceAll("[^" + skill + "]", "");


        return skill.startsWith(checkSkill);
    }
}
