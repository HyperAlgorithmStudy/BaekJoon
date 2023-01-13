package combination;

import java.util.Scanner;

public class P1010_bridge {

	public static void main(String[] args) {
		int[][] DP = new int[31][31];

		for (int i = 0; i < 31; i++) {
			DP[i][i] = 1; //i번에서 i개를 선택하는 경우의 수 1
			DP[i][1] = i; //i번에서 1개를 선택하는 경우의 수 i
			DP[i][0] = 1; //i번에서 0개를 선택하는 경우의 수 1
		}

		for (int i = 2; i < 31; i++) {
			for (int j = 1; j < i; j++) {
				DP[i][j] = DP[i - 1][j] + DP[i - 1][j - 1];
			}
		}

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println(DP[M][N]);
		}
	}

}
