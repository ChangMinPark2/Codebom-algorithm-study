package PCCE;

public class 문제10번 {
	public static void main(String[] args) {
		String str = "one plus four div three minus four mul four";
		str = str.replace("one", "1");
		str = str.replace("two", "2");
		str = str.replace("three", "3");
		str = str.replace("four", "4");
		str = str.replace("five", "5");
		String[] temp = str.split(" ");
		double answer = Double.parseDouble(temp[0]);

		for(int i = 0; i < temp.length - 1; i++) {
			if(temp[i].equals("plus")) {
				answer += Double.parseDouble(temp[i + 1]);
			}
			if(temp[i].equals("minus")) {
				answer -= Double.parseDouble(temp[i + 1]);
			}
			if(temp[i].equals("mul")) {
				answer *= Double.parseDouble(temp[i + 1]);
			}
			if(temp[i].equals("div")) {
				answer /= Double.parseDouble(temp[i + 1]);
			}
		}

		System.out.println((int)answer);

	}
}
