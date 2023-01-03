package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1920_binarySearch {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> A = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(A);

		st = new StringTokenizer(br.readLine());
		int targetNumber = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] target = new int[targetNumber];
		for (int i = 0; i < targetNumber; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < targetNumber; i++) {
			boolean find = false;
			int start = 0;
			int end = A.size() - 1;
			while (start <= end) {
				int M = (start + end) / 2;
				if (A.get(M) > target[i]) {
					end = M - 1;
				} else if (A.get(M) < target[i]) {
					start = M + 1;
				} else {
					find = true;
					break;
				}
			}
			if (find) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

	}
}