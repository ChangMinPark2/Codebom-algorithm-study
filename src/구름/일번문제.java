package 구름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일번문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long input = Long.parseLong(br.readLine());
		System.out.println(input * (long)Math.pow(10, input));
	}
}
