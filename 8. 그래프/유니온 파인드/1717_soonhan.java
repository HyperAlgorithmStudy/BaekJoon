package graph;

import java.util.Scanner;

public class P1717_unionFind {
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 원소개수
		int M = sc.nextInt(); // 질의개수

		parent = new int[N + 1];

		for (int i = 0; i <= N; i++) { //대표노드 1부터 시작 인덱스 = 대표노드 
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int Q = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (Q == 0) {
				union(a, b); // 집합 합치기
			} else {
				if (checkSame(a, b)) { // 같은 집합의 원소인지 확인하기
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void union(int a, int b) { // a,b의 대표 노드를 찾아서 대표노드끼리 연결하기
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}

	private static int find(int a) { // find 연산 a가 대표 노드면 return
		if (a == parent[a]) {
			return a;
		} else
			return parent[a] = find(parent[a]); // 재귀 함수의 형태로 구현 (경로 압축 부분)
	}

	private static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return true;
		}
		return false;
	}
}
