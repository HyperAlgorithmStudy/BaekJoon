package tree;

import java.util.Scanner;

public class P2042_segmentTreePrefixSum {
	static long[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // leaf node quantity 5
		int M = sc.nextInt(); // number of changes 2
		int K = sc.nextInt(); // number of prefix sum 2

		int treeHeight = 0; // 2^k >= N 인 k값을 구한다. k = treeHeight 3

		int x = N;
		while (x != 0) {
			x /= 2;
			treeHeight++;
		}

		int treeSize = (int) Math.pow(2, treeHeight + 1); // 2^3 * 2 결국 2^4
		int leafNodeStartIndex = treeSize / 2 - 1; // 인덱스 때문 - 1

		tree = new long[treeSize + 1]; // save leaf node data
		for (int i = leafNodeStartIndex + 1; i <= leafNodeStartIndex + N; i++) {
			tree[i] = sc.nextLong();
		}

		setTree(treeSize - 1); // 15, 트리 자료 구조 완성

		for (int i = 0; i < M + K; i++) {
			long a = sc.nextLong();
			int start = sc.nextInt();
			long end = sc.nextLong();

			if (a == 1) {
				updateValue(leafNodeStartIndex + start, end); // update start를 end로 바꾼다.
			} else if (a == 2) { // prefix sum
				start = start + leafNodeStartIndex; // tree의 index로 바꿔준다.
				end = end + leafNodeStartIndex;
				System.out.println(getSum(start, (int) end));
			} else {
				return;
			}
		}
	}

	private static long getSum(int start, int end) { // 17, 20
		long partSum = 0;
		while (start <= end) {
			if (start % 2 == 1) { // 부모 노드의 오른쪽에 있다는 뜻
				partSum = partSum + tree[start]; // 노드를 선택해준다. (부모노드의 오른쪽에 있음으로)
				start++;
			}
			if (end % 2 == 0) { // 부모 노드의 왼쪽에 있다는 뜻
				partSum = partSum + tree[end]; // 노드를 선택해준다. (부모노드의 왼쪽에 있음으로)
				end--;
			}
			start = start / 2;
			end = end / 2;
		}
		return partSum;
	}

	private static void updateValue(int index, long val) { // update method
		long diff = val - tree[index]; // 인덱스의 값과 바꿀 값 차이
		while (index > 0) {
			tree[index] = tree[index] + diff; // 부모노드를 타고 올라가면서 차이를 더해준다.
			index = index / 2;
		}

	}

	private static void setTree(int i) {
		while (i != 1) {
			tree[i / 2] += tree[i];
			i--;
		}
	}

}
