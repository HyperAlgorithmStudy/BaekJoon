package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1753_distance {
	public static int V, E, K;
	public static int distance[];
	public static boolean visited[];
	public static ArrayList<Edge> list[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt(); // node quantity
		E = sc.nextInt(); // edge quantity
		K = sc.nextInt(); // starting node

		visited = new boolean[V + 1];
		distance = new int[V + 1];
		list = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i <= V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) { // initialize
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			list[u].add(new Edge(v, w));
		}
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(K, 0)); // K is starting node
		distance[K] = 0;
		while (!q.isEmpty()) {
			Edge now = q.poll();
			int nowVertex = now.vertex;
			if (visited[nowVertex])
				continue;
			visited[nowVertex] = true;

			for (int i = 0; i < list[nowVertex].size(); i++) {
				Edge temp = list[nowVertex].get(i);
				int next = temp.vertex;
				int value = temp.value;
				if (distance[next] > distance[nowVertex] + value) {
					distance[next] = value + distance[nowVertex];
					q.add(new Edge(next, distance[next]));
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if(visited[i])
				System.out.println(distance[i]);
			else
				System.out.println("INF");
		}
	}

}

class Edge implements Comparable<Edge> {
	int vertex, value;

	Edge(int vertex, int value) {
		this.vertex = vertex;
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