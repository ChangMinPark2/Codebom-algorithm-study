package 백준_문제집_초보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B4_모음의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		while (true) {
			String repo = br.readLine();
			if (repo.equals("#")) break;
			int count = 0;
			for (char c : repo.toCharArray()) {
				if (c == 'a' || c == 'e' || c == 'i'|| c == 'o' || c == 'u'
					|| c == 'A' || c == 'E' || c == 'I'|| c == 'O' || c == 'U') {
					count++;
				}
			}
			list.add(count);
		}
		for (int i : list) {
			System.out.println(i);
		}
	}
}
