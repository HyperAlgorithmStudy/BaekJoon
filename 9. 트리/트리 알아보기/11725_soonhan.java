package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class P11725_searchingTreeParents {
	static ArrayList<Integer>[] tree;
	static int[] answer;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		tree = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			tree[x].add(y);
			tree[y].add(x);
		}

		answer = new int[N + 1];

		int rootNode = 1;
		dfs(rootNode);

		for (int i = 2; i <= N; i++) {
			System.out.println(answer[i]);
		}
	}

	private static void dfs(int node) {
		if (visited[node])
			return;
		visited[node] = true;

		for (int i : tree[node]) {
			if (visited[i] == false)
				answer[i] = node;
			dfs(i);
		}
	}

}
