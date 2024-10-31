package 프로그래머스_MYSQL;

public class LV2_가격이제일비싼식품의정보출력하기 {
    /**
     * 가격이 제일 비싼걸 조회하기
     * SELECT *
     * FROM FOOD_PRODUCT
     * ORDER BY PRICE DESC
     * LIMIT 1
     *
     * - 방법 2 -
     * SELECT *
     * FROM FOOD_PRODUCT
     * WHERE PRICE = (SELECT MAX(PRICE)
     *                FROM FOOD_PRODUCT)
     */
}
