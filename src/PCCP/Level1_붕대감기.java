package PCCP;

import java.util.*;

public class Level1_붕대감기 {
    /**
     * t초 동안, 1초마다 x 회복 / t초 연속으로 감는 데 성공한다면 y만큼 추가 회복
     * 공격 당하면, 회복 취소 || 연속 성공 시간이 0초로 초기화.
     * 0이하 죽음.
     * t, x, y -> bandage
     * 최대체력 -> health
     * 공격하는 시간, 피해량 -> attacks
     * 모든 공격이 끝난 이후 남은 체력을 return
     * <p>
     * <문제풀이흐름>
     * 마지막 시간이 0이 될 떄 까지. 반복문을 돌린다.
     * 현재체력, 연속성공 변수
     * health가 0보다 작거나 같다면 즉시 종료.
     **/

    public int solution(int[] bandage, int health, int[][] attacks) {
        int lastTime = attacks[attacks.length - 1][0];
        int keepTime = 0;
        int curhealth = health;

        Map<Integer, Integer> monster = new HashMap<>();

        for (int[] arr : attacks) {
            monster.put(arr[0], arr[1]);
        }

        for (int i = 1; i <= lastTime; i++) {
            if (monster.containsKey(i)) {
                curhealth -= monster.get(i);
                keepTime = 0;
            } else {
                curhealth += bandage[1];
                keepTime++;
                if (keepTime == bandage[0]) {
                    curhealth += bandage[2];
                    keepTime = 0;
                }

                if (curhealth > health) {
                    curhealth = health;
                }
            }

            if (curhealth <= 0) {
                return -1;
            }
        }
        return curhealth;
    }
}
