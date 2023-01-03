package greedy;

import java.util.Scanner;

public class P11047_coin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		int cnt = 0;
		int i = N-1;
		while (K != 0) {
			if (K < A[i]) {
				i--;
			} else {
				cnt = cnt + (K / A[i]);
				K = K % A[i];
			}
		}
		System.out.println(cnt);
	}
}