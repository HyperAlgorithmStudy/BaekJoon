package numberTheory;

import java.util.Scanner;

public class P1934_gcd {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] A = new int[T];
		int[] B = new int[T];
		int[] cloneB = new int[T];
		int[] cloneA = new int[T];

		for (int i = 0; i < T; i++) {
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}

		for (int i = 0; i < T; i++) {
			cloneA[i] = A[i];
			cloneB[i] = B[i];
		}

		int gcd = 0;
		int lcm = 0;
		int quotient = 0;
		for (int i = 0; i < T; i++) {
			while (B[i] != 0 || A[i] != 0) {
				if (A[i] == 1) {
					gcd = A[i];
					break;
				}
				B[i] = B[i] % A[i];
				if (B[i] == 0) {
					gcd = A[i];
					break;
				} else if (A[i] == 0) {
					gcd = B[i];
					break;
				}
				A[i] = A[i] % B[i];
				if (B[i] == 0) {
					gcd = A[i];
					break;
				} else if (A[i] == 0) {
					gcd = B[i];
					break;
				}
			}
			quotient = cloneB[i] / gcd;
			lcm = quotient * cloneA[i];
			System.out.println(lcm);
		}

	}
}