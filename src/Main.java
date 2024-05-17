import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) throws IOException {
		String[] testCases = {"1 2", "3 4", "5 6", "7 8", "9 10", "11 12", "13 14", "15 16", "17 18", "19 20"};
		String[] expectedOutputs = {"3", "7", "11", "15", "19", "23", "27", "31", "35", "39"};

		// 각 테스트케이스에 대해 실행
		for (int i = 0; i < testCases.length; i++) {
			String input = testCases[i];
			String expectedOutput = expectedOutputs[i];

			// 테스트케이스에 해당하는 입력값을 표준 입력으로 제공
			System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

			// 사용자 코드 실행
			Main2.main(null);

			// 예상 출력값과 비교하여 결과 출력
			String actualOutput = captureOutput();
			if (actualOutput.trim().equals(expectedOutput)) {
				System.out.println("Test case " + (i + 1) + " passed");
			} else {
				System.out.println("Test case " + (i + 1) + " failed");
			}
		}
	}

	// 표준 출력을 캡처하여 반환
	private static String captureOutput() {
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(out));
		return out.toString();
	}
}
