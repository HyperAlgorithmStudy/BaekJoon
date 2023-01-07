package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1516_game {
	static ArrayList<Integer>[] A;
	static int[] inDegree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] durationOfTime = new int[N + 1];
		int[] result = new int[N+1];
		A = new ArrayList[N + 1];
		inDegree = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		int k = 1;
		while (k != N + 1) {
			int j = 1;
			durationOfTime[k] = sc.nextInt();
			while (k <= N) {
				int x = sc.nextInt();
				if (x == -1) {
					j++;
					break;
				}
				A[x].add(k);
				inDegree[k]++;
				j++;
			}
			k++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : A[now]) {
				inDegree[next]--;
				result[next] = Math.max(result[next], result[now] + durationOfTime[now]);
				if (inDegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(result[i] + durationOfTime[i]);
		}
	}

}