package 코드봄_level2;

public class Level2_멀리뛰기 {
	public long solution(int n) {
		long[] mem = new long[2001];
		mem[1] = 1;
		mem[2] = 2;

		for(int i = 3; i < 2001; i++) {
			mem[i] = (mem[i - 1] + mem[i - 2]) % 1234567;
		}

		return mem[n];
	}
}
