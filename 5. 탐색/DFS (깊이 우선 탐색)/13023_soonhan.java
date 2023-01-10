package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class P13023_friend {
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static boolean arrive;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // node quantity
		int M = sc.nextInt(); // edge quantity
		visited = new boolean[N];
		arrive = false;
		
		A = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) { // save data
			int x = sc.nextInt();
			int y = sc.nextInt();

			A[x].add(y);
			A[y].add(x);
		}

		for (int i = 0; i < N; i++) { // 각 사람별로 깊이가 5인 관계가 있는지 탐색한다.
			dfs(i, 1);
			if (arrive)
				break;
		}

		if (arrive)
			System.out.println("1");
		else
			System.out.println("0");

	}

	// dfs
	private static void dfs(int nowNode, int depth) {
		if (depth == 5 || arrive) {
			arrive = true;
			return;
		}

		visited[nowNode] = true;
		for (int i : A[nowNode]) {
			if (!visited[i]) {
				dfs(i, depth + 1);
			}
		}
		visited[nowNode] = false;
	}

}
