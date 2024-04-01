package 백준.수학;

import java.io.*;
import java.util.*;

public class B3_소수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String[] repo = br.readLine().split(" ");

		System.out.println(Arrays.stream(repo).mapToInt(Integer::parseInt).filter(i -> decimal(i)).count());
	}

	static boolean decimal(int a) {
		int count = 0;
		for (int i = 1; i <=a; i++) {
			if (a % i == 0) count++;
		}

		if (count == 2) return true;
		return false;
	}
}
