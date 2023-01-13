package combination;

import java.util.Scanner;

public class P11050_binomialCoefficient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 총 개수
		int K = sc.nextInt(); // 선택의 수

		int[][] DP = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			DP[i][i] = 1;
			DP[i][0] = 1;
			DP[i][1] = i;
		}
		
		//점화식 bottom-up
		for (int i = 2; i <= N; i++) { //1은 위에서 모두 채워줌 
			for (int j = 1; j < i; j++) { //고르는 수의 개수가 전체 개수를 넘을 수 없다. 
				DP[i][j] = DP[i-1][j] + DP[i-1][j-1]; 
			}
		}
		System.out.println(DP[N][K]);
	}

}
