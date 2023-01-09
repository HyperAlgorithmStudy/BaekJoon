package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1916_minCost {
	public static ArrayList<Edge>[] list;
	public static int[] cost;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // city quantity = Node, 5
		int M = sc.nextInt(); // bus quantity = Edge, 8

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		cost = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			cost[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= M; i++) {
			int u = sc.nextInt();
			int x = sc.nextInt();
			int w = sc.nextInt();
			list[u].add(new Edge(x, w));
		}

		visited = new boolean[N + 1];
		int startingPoint = sc.nextInt();
		int destination = sc.nextInt();

		PriorityQueue<Edge> q = new PriorityQueue<>();

		q.add(new Edge(startingPoint, 0));
		cost[startingPoint] = 0;

		while (!q.isEmpty()) {
			Edge current = q.poll();
			int currentNode = current.node;
			if (visited[currentNode])
				continue;
			visited[currentNode] = true;

			for (int i = 0; i < list[currentNode].size(); i++) {
				int next = list[currentNode].get(i).node;
				int nextValue = list[currentNode].get(i).value;
				if (cost[next] > cost[currentNode] + nextValue) {
					cost[next] = cost[currentNode] + nextValue;
					q.add(new Edge(next, cost[next]));
				}
			}
		}
		System.out.println(cost[destination]);
	}
}

class Edge implements Comparable<Edge> {
	int node, value;

	public Edge(int node, int value) {
		this.node = node;
		this.value = value;
	}

	@Override
	public int compareTo(Edge e) {
		if (this.value > e.value)
			return 1;
		else
			return -1;
	}

}
