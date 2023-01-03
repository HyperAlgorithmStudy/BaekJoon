package greedy;

import java.util.Scanner;

public class P1541_lostBracket {
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String example = sc.next();
		String[] str = example.split("-");

		int tempSum = 0;
		for (int i = 0; i < str.length; i++) {
			tempSum = sum(str[i]);
			if (i == 0) {
				result = result + tempSum;
			} else {
				result = result - tempSum;
			}
		}
		System.out.println(result);
	}

	private static int sum(String str) {
		int sum = 0;
		String[] temp = str.split("\\+");

		for (int i = 0; i < temp.length; i++) {
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}
}