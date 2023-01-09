package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11657_timeMachine {
	public static Edge edges[];
	public static long[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // node quantity
		int M = Integer.parseInt(st.nextToken()); // edge quantity

		edges = new Edge[M + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(A, B, C); // start, end, value
		}

		distance = new long[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		int startingPoint = 1;
		distance[startingPoint] = 0;
		for (int i = 1; i < N; i++) { // N보다 1개 적은 수 만큼 반복하기
			for (int j = 0; j < M; j++) {
				Edge edge = edges[j];
				if (distance[edge.node] != Integer.MAX_VALUE
						&& distance[edge.endNode] > distance[edge.node] + edge.value) {
					distance[edge.endNode] = distance[edge.node] + edge.value;
				}
			}
		}
		boolean negativeCycle = false;

		for (int i = 0; i < M; i++) { // 음수 사이클 확인
			Edge edge = edges[i];
			if (distance[edge.node] != Integer.MAX_VALUE && distance[edge.endNode] > distance[edge.node] + edge.value) {
				negativeCycle = true;
			}
		}

		if (!negativeCycle) {
			for (int i = 2; i <= N; i++) {
				if (distance[i] == Integer.MAX_VALUE) // 음의 사이클이 있을때
					bw.write("-1" + "\n");
				else
					bw.write(distance[i] + "\n");
			}
		} else {
			bw.write("-1" + "\n");
		}
		bw.flush();
		bw.close();
	}

}
