package 백준.수학;

import java.io.*;
import java.util.*;

/**
 * 세 변의 길이가 모두 같은 경우 -> E ~~
 * 두 변의 길이만 같은 경우 -> Isoscel
 * 세 변의 길이가 모두 다른 경우 -> Scalene
 */

public class B3_삼각형과세변 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();
		while (true) {
			String[] repo = br.readLine().split(" ");
			int a = Integer.parseInt(repo[0]);
			int b = Integer.parseInt(repo[1]);
			int c = Integer.parseInt(repo[2]);

			if (a == b && b == c && a == c && a == 0) {
				break;
			}

			if (isNotTriangle(a, b, c)) {
				list.add("Invalid");
				continue;
			}

			if (a == b && b == c) {
				list.add("Equilateral");
				continue;
			} else if (a == b || b == c || a == c) {
				list.add("Isosceles");
			} else
				list.add("Scalene");
		}

		for (String str : list) {
			System.out.println(str);
		}
	}

	private static boolean isNotTriangle(int a, int b, int c) {
		int max = Math.max(a, Math.max(b, c));
		if (max == a) {
			return b + c <= a;
		} else if (max == b) {
			return a + c <= b;
		} else
			return a + b <= c;
	}
}
