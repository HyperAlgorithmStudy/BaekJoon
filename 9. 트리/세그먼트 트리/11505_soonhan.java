package tree;

import java.util.Scanner;

public class P11505_segmentTreeMod {
	static long[] tree;
	static int MOD;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // leaf node quantity 5
		int M = sc.nextInt(); // number of changes 2
		int K = sc.nextInt(); // number of MOD 2

		int treeHeight = 0; // 2^k >= N인 k값을 구한다.k=treeHeight 3

		int x = N;
		while (x != 0) {
			x /= 2;
			treeHeight++;
		}

		int treeSize = (int) Math.pow(2, treeHeight + 1); // 2^3 * 2 결국 2^4 = 16
		int leafNodeStartIndex = treeSize / 2;
		int leftNodeStartIndex = leafNodeStartIndex - 1;

		MOD = 1000000007;
		tree = new long[treeSize + 1];
		for (int i = 0; i < tree.length; i++) { // 곱셈임으로 초깃값을 1로 설정
			tree[i] = 1;
		}
		// save leaf node data in tree
		for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
			tree[i] = sc.nextLong();
		}

		setTree(treeSize - 1); // 트리 자료 구조

		for (int i = 0; i < M + K; i++) {
			long a = sc.nextLong();
			int start = sc.nextInt(); // 업데이트의 경우 start를 end(value)로 바꿔준다.
			long end = sc.nextLong(); // 구간 곱의 경우 start부터 end까지의 구간 곱

			if (a == 1) {
				updateValue(leftNodeStartIndex + start, end);
			} else if (a == 2) { // 구간 곱
				start = start + leftNodeStartIndex; // tree의 index로 바꿔준다.
				end = end + leftNodeStartIndex;
				System.out.println(getMultiplication(start, (int) end));
			}
		}

	}

	private static long getMultiplication(int start, int end) {
		long partMultiplication = 1;
		while (start <= end) {
			if (start % 2 == 1) { // 부모 노드의 오른쪽에 있다는 뜻 (노드를 선택해준다.)
				partMultiplication = partMultiplication * tree[start] % MOD;
				start++;
			}
			if (end % 2 == 0) { // 부모 노드의 왼쪽에 있다는 뜻 (노드를 선택해준다.)
				partMultiplication = partMultiplication * tree[end] % MOD;
				end--;
			}
			start = start / 2;
			end = end / 2;
		}

		return partMultiplication;
	}

	private static void updateValue(int index, long value) {
		tree[index] = value;
		while (index > 1) { // 현재 노드의 양쪽 자식을 찾아 곱한다.
			index = index / 2;
			tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
		}

	}

	private static void setTree(int i) {
		while (i != 1) {
			tree[i / 2] = tree[i / 2] * tree[i] % MOD;
			i--;
		}
	}

}
