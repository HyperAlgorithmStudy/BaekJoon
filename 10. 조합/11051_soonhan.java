package combination;

import java.util.Scanner;

public class P11051_binomialCoefficient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 총 개수
		int K = sc.nextInt(); // 선택 수

		int[][] DP = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			DP[i][i] = 1;
			DP[i][0] = 1;
			DP[i][1] = i;
		}

		for (int i = 2; i <= N; i++) { //  i가 1인경우 선택 수는 모두1 위에서 모두 채워줌 
			for (int j = 1; j < i; j++) {
				DP[i][j] = DP[i - 1][j] + DP[i - 1][j - 1]; 
				DP[i][j] = DP[i][j] % 10007; // MOD
			}
		}
		System.out.println(DP[N][K]);
	}

}
