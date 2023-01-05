package numberTheory;

import java.util.ArrayList;
import java.util.Scanner;

public class P1747_primeNumber_palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[1004000];
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 2; i < A.length; i++) {
			A[i] = i;
			
		}
		for (int i = 2; i <= Math.sqrt(1004000); i++) {
			if (A[i] == 0)
				continue;
			for (int j = 2 * i; j < A.length; j = j + i) {
				A[j] = 0;
			}
		}
		for (int i = N; i < A.length; i++) {
			if(A[i] == 4 || A[i] == 6 || A[i] == 8) {
				A[i] = 0;
			}
			if (A[i] != 0)
				arr.add(i);
		}

		for (int i = 0; i < arr.size(); i++) {
			int start = 0;
			String indexValue = arr.get(i).toString();
			char[] c = indexValue.toCharArray();
			int end = c.length - 1;

			while (start <= end) {
				if (c[start] < 10) {
					System.out.println(indexValue);
					break;
				}
				if (c[start] == c[end]) {
					start++;
					end--;
					if (start >= end) {
						System.out.println(indexValue);
						i = arr.size();
						break;
					}
				} else {
					break;
				}
			}
		}
	}
}