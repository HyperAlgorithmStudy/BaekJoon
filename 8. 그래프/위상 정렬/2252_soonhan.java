package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252_line {
	static ArrayList<Integer>[] A;
	static int[] D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		A = new ArrayList[N + 1];
		D = new int[N + 1];
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			A[x].add(y);
			D[y]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (D[i] == 0) {
				queue.offer(i);
				result.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : A[now]) {
				D[next]--;
				if (D[next] == 0) {
					queue.offer(next);
					result.add(next);
				}
			}
		}
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}