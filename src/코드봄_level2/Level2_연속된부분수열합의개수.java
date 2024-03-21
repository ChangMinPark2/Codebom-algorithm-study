package 코드봄_level2;
import java.util.*;

public class Level2_연속된부분수열합의개수 {
	public int solution(int[] elements) {
		Set<Integer> set = new HashSet<>();

		for(int i = 1; i <= elements.length; i++) {
			for(int j = 0; j < elements.length; j++) {
				int sum = 0;

				for(int z = j; z < i + j; z++) {
					sum += elements[z % elements.length];
				}
				set.add(sum);
			}
		}

		return set.size();
	}
}
