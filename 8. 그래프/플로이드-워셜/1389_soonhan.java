package graph;

import java.util.Scanner;

public class P1389_floyd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // node quantity 5
		int M = sc.nextInt(); // edge quantity 5

		int[][] distance = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) { // initialize
			for (int j = 1; j <= N; j++) {
				distance[i][j] = 10000001;
				if (i == j)
					distance[i][j] = 0;
			}
		}
		for (int i = 0; i < M; i++) { // two-way save 1
			int x = sc.nextInt();
			int y = sc.nextInt();
			distance[x][y] = 1;
			distance[y][x] = 1;
		}

		// floyd warshall algorithm
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (distance[i][j] > distance[i][k] + distance[k][j])
						distance[i][j] = distance[i][k] + distance[k][j];
				}
			}
		}

		int[] sum = new int[N + 1];
		int temp = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				sum[i] = sum[i] + distance[i][j];
			}
		}
		int min = 0;
		for (int i = 1; i <= N; i++) {
			if (temp > sum[i]) {
				temp = sum[i];
				min = i;
			} else {
				continue;
			}
		}
		System.out.println(min);
	}
}
