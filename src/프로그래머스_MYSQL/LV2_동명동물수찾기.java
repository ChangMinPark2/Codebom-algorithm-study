package 프로그래머스_MYSQL;

public class LV2_동명동물수찾기 {
    /**
     * 동물 이름 중 두번 이상 쓰인 이름과, 해당 이름이 쓰인 횟수를 조회하는 SQL 문을 작성하기.
     * 이름 없는 동물은 집계에서 제외하며, 결과는 이름순으로 조회한다.
     * -- 코드를 입력하세요
     * SELECT NAME, COUNT(NAME)
     * FROM ANIMAL_INS
     * GROUP BY NAME
     * HAVING COUNT(NAME) >= 2
     * ORDER BY NAME
     */
}
