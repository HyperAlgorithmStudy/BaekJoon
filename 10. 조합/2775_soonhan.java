package combination;

import java.util.Scanner;

public class P2275_apartment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // test case
		int[][] DP = new int[15][15]; // n은 14까지 

		for (int i = 0; i < 15; i++) {
			DP[0][i] = i;
			DP[i][1] = 1;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				DP[i][j] = DP[i][j - 1] + DP[i - 1][j];
			}
		}
		
		for(int i = 0; i < T; i++) {
			int K = sc.nextInt(); // floor
			int N = sc.nextInt(); // room number
			System.out.println(DP[K][N]);
		}
	}

}
