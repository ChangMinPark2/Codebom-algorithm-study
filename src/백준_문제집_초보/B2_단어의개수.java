package 백준_문제집_초보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class B2_단어의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] repo = br.readLine().split(" ");

		int count = 0;

		for (String str : repo) {
			if (!str.isBlank()) count++;
		}

		System.out.println(count);
	}
}
