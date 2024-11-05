package 프로그래머스_MYSQL;

public class LV2_고양이와개는몇마리있을까 {
    /**
     * 동물 보호소에 들어온 동물 중 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성해주세요.
     * 이때 고양이를 개보다 먼저 조회해주세요.
     *
     * -- 코드를 입력하세요
     * SELECT ANIMAL_TYPE, count(ANIMAL_TYPE) AS 'count'
     * FROM ANIMAL_INS
     * GROUP BY ANIMAL_TYPE
     * ORDER BY ANIMAL_TYPE
     */
}
