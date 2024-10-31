package 프로그래머스_MYSQL;

public class LV1_경기도에위치한식품창고목록출력하기 {
    /**
     * 경기도에 위치한 공장 id, 이름, 주소, 냉동시설 여부 조회하기
     * 단, 냉동시설여부가 null이라면 n으로 표현하고 id순으로 오름차순하기
     * SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IFNULL(FREEZER_YN, 'N')
     * FROM FOOD_WAREHOUSE
     * WHERE ADDRESS LIKE '경기도%'
     * ORDER BY WAREHOUSE_ID
     */
}
