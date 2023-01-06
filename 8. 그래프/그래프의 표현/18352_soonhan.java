package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P18352_city {
	static int[] visited;
	static ArrayList<Integer>[] A;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 4
		int M = sc.nextInt(); // 4
		int K = sc.nextInt(); // 2
		int X = sc.nextInt(); // 1

		A = new ArrayList[N + 1];
		ArrayList<Integer> minDistance = new ArrayList<>();

		for (int i = 1; i <= N; i++) { // 노드는 1부터 시작해야한다.
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			A[start].add(end);
		}

		visited = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			visited[i] = -1;
		}
		BFS(X);
		for (int i = 0; i <= N; i++) {
			if (visited[i] == K) {
				minDistance.add(i);
			}
		}
		if (minDistance.isEmpty()) {
			System.out.println("-1");
		} else {
			Collections.sort(minDistance); // 오름차순으로 출력
			for (int i : minDistance) {
				System.out.println(i);
			}
		}

	}

	private static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node]++;
		while(!queue.isEmpty()) {
			int nowNode = queue.poll();
			for(int i : A[nowNode]) {
				if(visited[i] == -1) {
					visited[i] = visited[nowNode] + 1; //이전 노드에서 방문 노드거리 +1 
					queue.add(i); //큐에 데이터 삽입 
				} 
			}
		}
	}
}
