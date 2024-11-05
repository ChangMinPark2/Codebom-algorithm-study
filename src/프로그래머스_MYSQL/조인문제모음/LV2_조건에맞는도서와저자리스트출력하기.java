package 프로그래머스_MYSQL.조인문제모음;

public class LV2_조건에맞는도서와저자리스트출력하기 {
    /**
     * '경제' 카테고리에 속하는 도서들의 도서 ID(BOOK_ID),
     * 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력하는 SQL문을 작성해주세요.
     * 결과는 출판일을 기준으로 오름차순 정렬해주세요.
     *
     * -- 코드를 입력하세요
     * SELECT A.BOOK_ID, B.AUTHOR_NAME, date_format(A.PUBLISHED_DATE, "%Y-%m-%d")
     * AS PUBLISHED_DATE
     * FROM Book A JOIN AUTHOR B ON A.AUTHOR_ID = B.AUTHOR_ID
     * WHERE A.CATEGORY = '경제'
     * ORDER BY A.PUBLISHED_DATE
     */
}
