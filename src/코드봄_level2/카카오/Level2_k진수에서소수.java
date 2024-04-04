package 코드봄_level2.카카오;

public class Level2_k진수에서소수 {
	public int solution(int n, int k) {
		String tran = Integer.toString(n, k);
		String[] arr = tran.split("0");
		int answer = 0;

		for (String data : arr) {
			if (data.equals(""))
				continue;

			long num = Long.parseLong(data);
			if (isPrime(num)) {
				answer++;
			}
		}

		return answer;
	}

	public boolean isPrime(long a) {
		if (a < 2)
			return false;

		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

}
