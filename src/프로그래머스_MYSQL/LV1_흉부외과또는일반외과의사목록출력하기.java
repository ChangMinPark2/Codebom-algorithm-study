package 프로그래머스_MYSQL;

public class LV1_흉부외과또는일반외과의사목록출력하기 {
    /**
     * CS, GS인 의사의 이름, 의사ID, 진료과, 고용일자를 조회하는 SQL문
     * 단, 결과는 고용일자 기준으로 내침차순 정렬하고, 같다면 이름을 기준으로 오름차순하기
     *
     * -- 코드를 입력하세요
     * SELECT DR_NAME, DR_ID, MCDP_CD, date_format(HIRE_YMD,"%Y-%m-%d")
     * FROM DOCTOR
     * WHERE MCDP_CD IN('CS','GS')
     * ORDER BY HIRE_YMD DESC, DR_NAME
     */
}
