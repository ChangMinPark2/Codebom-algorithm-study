package 프로그래머스_MYSQL;

public class LV3_조건별로분류하여주문상태출력하기 {
    /**
     * FOOD_ORDER 테이블에서 2022년 5월 1일을 기준으로 주문 ID, 제품 ID, 출고일자, 출고여부
     * 를 조회하는 SQL문을 작성해주세요.
     * 출고여부는 2022년 5월 1일까지 출고완료로
     * 이 후 날짜는 출고 대기로 미정이면 출고미정으로 출력해주시고,
     * 결과는 주문 ID를 기준으로 오름차순 정렬해주세요.
     *
     * SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
     * IF(
     *     OUT_DATE <='2022-05-01','출고완료',
     *     IF(OUT_DATE>'2022-05-01','출고대기','출고미정')
     * ) `출고여부`
     * FROM FOOD_ORDER
     * ORDER BY ORDER_ID
     */
}
