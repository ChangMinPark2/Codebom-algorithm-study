package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class B3_삼각형과세변 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			String[] repo = br.readLine().split(" ");
			int a = Integer.parseInt(repo[0]);
			int b = Integer.parseInt(repo[1]);
			int c = Integer.parseInt(repo[2]);

			if (a + b <= c || a + c <= b || b + c <= a) {
				list.add("Invalid");
			} else if (a == b && b == c) {
				list.add("Equilateral");
			} else if (a == b || a == c || b == c) {
				list.add("Isosceles");
			} else {
				list.add("Scalene");
			}
		}

		for (int i = 0; i < list.size() - 1; i++) {
			System.out.println(list.get(i));
		}
	}
}
