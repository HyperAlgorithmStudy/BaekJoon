package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2343_guitarLesson {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		int start = 0;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (A[i] > start) {
				start = A[i];
			} end += A[i];
		}

		while (start <= end) {
			int cnt = 0;
			int sum = 0;
			int mid = (start + end) / 2;

			for (int i = 0; i < N; i++) {
				if (sum + A[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum = sum + A[i];
			}
			if (sum != 0) {
				cnt++;
			}
			if (cnt > M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(start);
	}
}