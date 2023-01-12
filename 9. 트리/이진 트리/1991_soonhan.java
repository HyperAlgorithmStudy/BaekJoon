package tree;

import java.util.Scanner;

public class P1991_treeTraversal {
	static int[][] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // node quantity 7
		tree = new int[26][2];
		
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String [] temp = sc.nextLine().split(" ");
			int node = temp[0].charAt(0) - 'A'; // 인덱스로 변환하기 위해 A문자 빼기 
			char left = temp[1].charAt(0);
			char right = temp[2].charAt(0);
			
			if(left == '.') { //자식 노드가 없을 때 -1 저장하기 
				tree[node][0] = -1;;
			} else {
				tree[node][0] = left - 'A';
			}
			
			if(right == '.') {
				tree[node][1] = -1;
			} else {
				tree[node][1] = right - 'A';
			}
		}
		
		preOrderTraversal(0); //전위 순회 
		System.out.println();
		
		inOrderTraversal(0); //중위 순회 
		System.out.println();
		
		postOrderTraversal(0); //후위 순회 
		System.out.println();
		
	}
	private static void preOrderTraversal(int now) {
		if(now == -1)
			return;
		System.out.print((char)(now + 'A')); //현재 노드 
		preOrderTraversal(tree[now][0]); // 왼쪽 탐색 
		preOrderTraversal(tree[now][1]); // 오른쪽 탐색 
	}
	
	private static void inOrderTraversal(int now) {
		if(now == -1)
			return;
		inOrderTraversal(tree[now][0]); // 왼쪽 탐색 
		System.out.print((char)(now + 'A')); //현재 노드 
		inOrderTraversal(tree[now][1]); // 오른쪽 탐색 
	}

	private static void postOrderTraversal(int now) {
		if(now == -1)
			return;
		postOrderTraversal(tree[now][0]); // 왼쪽 탐색 
		postOrderTraversal(tree[now][1]); // 오른쪽 탐색 
		System.out.print((char)(now + 'A')); //현재 노드 
	}
}
