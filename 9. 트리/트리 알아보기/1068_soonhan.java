package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class P1068_leafNode {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int deleteNodeNumber;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		tree = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		int rootNode = 0;

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if (x == -1) {
				rootNode = i;
				continue;
			} else {
				tree[i].add(x);
				tree[x].add(i);
			}
		}

		deleteNodeNumber = sc.nextInt();

		if (deleteNodeNumber == rootNode) {
			System.out.println(0);
		} else {
			dfs(rootNode);
			System.out.println(answer);
		}
	}

	private static void dfs(int node) {
		visited[node] = true;
		int childNode = 0;

		for (int i : tree[node]) {
			if (visited[i] == false && i != deleteNodeNumber) {
				childNode++;
				dfs(i);
			}
		}
		if (childNode == 0) {
			answer++;
		}
	}
}
