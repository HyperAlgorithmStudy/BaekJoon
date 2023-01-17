package dynamicProgramming;

import java.util.Scanner;

public class P10844_stair {
	static long[][] DP;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		DP = new long[N + 1][11]; // 0~9 가 들어간다. size 11
		// 길이가 n인 계단에서 h인 높이로 종료
		// 0 부터 시작할 수 없음
		for (int i = 1; i <= 9; i++) {
			DP[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			DP[i][0] = DP[i - 1][1];
			DP[i][9] = DP[i - 1][8];
			for (int h = 1; h <= 8; h++) {
				DP[i][h] = (DP[i - 1][h - 1] + DP[i - 1][h + 1]) % 1000000000;
			}
		}
		long answer = 0;
		for (int i = 0; i < 10; i++) {
			answer = (answer + DP[N][i]) % 1000000000;
		}

		System.out.println(answer);
	}

}
