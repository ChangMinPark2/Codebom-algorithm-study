package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계란에는 내구도와 무게가 정해져 있음.
 * 계란으로 계란을 치면 각 계란의 내구도는 상대 계란의 무게만큼 깍이게 된다.
 * 0 이하인 순간 깨진다.
 * 일렬로 놓여있는 계란에 대해 왼쪽부터 차례대로 들어서 한 번씩만 다른 계란을 쳐 많은 계란을 깨는 문제이다.
 * 1. 가장 왼쪽의 계란을 든다.
 * 2. 든 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다. 손에 든 계란이 깨졌거나, 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다.
 * 이 후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
 * 3. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 진행한다. 단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을
 * 치는 과정을 종료한다ㅣ
 *
 */
public class G5_16987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] repo = br.readLine().split(" ");

    }
}
