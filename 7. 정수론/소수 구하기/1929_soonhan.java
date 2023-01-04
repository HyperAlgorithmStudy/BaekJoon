package numberTheory;

import java.util.Scanner;

public class P1929_getPrimeNumber {
	static int j;
	static int[] A;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		A = new int[N+1];

		for (int i = 1; i < N+1; i++) {
			A[i] += i;
		}

		for (int i = 1; i < A.length; i++) {
			if (A[i] == 1 || A[i] == 4 || A[i] == 6 || A[i] == 8 || A[i] == 9) {
				delete(A, i);
				A[i] = 0;
			} else {
				delete(A, i);
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] != 0 && A[i] >= M) {
				System.out.println(A[i]);
			}
		}
	}

	private static void delete(int[] arr, int i) {
		j = 1;
		A = arr;
		while (A[i] != A[A.length - 1]) {
			if (A[i] == 0 || A[i] == 1) {
				break;
			}
			if (i + (A[i] * j) >= A.length) {
				break;
			}
			A[i + (A[i] * j)] = 0;
			j++;
		}
	}