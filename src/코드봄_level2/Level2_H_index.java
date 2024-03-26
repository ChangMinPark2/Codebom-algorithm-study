package 코드봄_level2;

public class Level2_H_index {
	public int solution(int[] citations) {
		int max = Integer.MAX_VALUE;

		for(int i = 0; i < citations.length; i++) {
			int count = 1;

			for(int j = i + 1; j < citations.length; j++) {
				if(citations[i] <= citations[j]){
					count++;
				}
				if(count == citations[i] && citations.length - count < count && citations[i] < max) {
					max = citations[i];
				}
			}
		}

		return max;
	}
}
