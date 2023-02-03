package kakaoBlind2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P4_양궁대회_re {
	static int[] apeach;
	static int N;
	static int maxDiff = Integer.MIN_VALUE;
	static List<Result> res = new ArrayList<>();

	public static void main(String[] args) {
		int n = 5;
//		int n_1 = 1;
//		int n_2 = 9;
//		int n_3 = 10;
//		int n_4 = 2;
		int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
//		int[] info_1 = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//		int[] info_2 = { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 };
//		int[] info_3 = { 0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3 };
//		int[] info_4 = { 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(Arrays.toString(solution(n, info)));
//		System.out.println(Arrays.toString(solution(n_1, info_1)));
//		System.out.println(Arrays.toString(solution(n_2, info_2)));
//		System.out.println(Arrays.toString(solution(n_3, info_3)));
//		System.out.println(Arrays.toString(solution(n_4, info_4)));
	}

	public static int[] solution(int n, int[] info) {
		N = n;
		apeach = info;
		shoot(0, 0, new int[11]);
		if (res.isEmpty()) {
			return new int[] { -1 };
		}
		Collections.sort(res);
		return res.get(0).target;
	}

	private static void shoot(int cnt, int idx, int[] lion) {
		// 점수비교, 탈출조건
		if (cnt == N) {
			compareScore(lion);
			return;
		}

		for (int i = idx; i < 11; i++) {
			lion[i]++;
			shoot(cnt + 1, i, lion);
			lion[i]--;
		}
	}

	private static void compareScore(int[] lion) {
		int apeachScore = 0;
		int lionScore = 0;
		for (int i = 0; i < apeach.length; i++) {
			if (apeach[i] == 0 && lion[i] == 0) {
				continue;
			}
			if (apeach[i] >= lion[i]) {
				apeachScore += 10 - i;
			} else {
				lionScore += 10 - i;
			}
		}
		if (lionScore > apeachScore) {
			int diff = lionScore - apeachScore;
			if (diff > maxDiff) {
				maxDiff = diff;
				res.clear();
				res.add(new Result(Arrays.copyOf(lion, 11)));
			} else if (diff == maxDiff) {
				res.add(new Result(Arrays.copyOf(lion, 11)));
			}
		}
	}

	static class Result implements Comparable<Result> {
		int[] target;

		public Result(int[] target) {
			this.target = target;
		}

		@Override
		public int compareTo(Result o) {
			for (int i = target.length - 1; i >= 0; i--) {
				if (target[i] != o.target[i]) {
					return o.target[i] - target[i];
				}
			}
			return 0;
		}
	}
}
