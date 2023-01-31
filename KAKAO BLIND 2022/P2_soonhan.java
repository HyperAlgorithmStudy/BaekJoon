package kakaoBlind2022;

import java.util.ArrayList;

public class P2_k진수에서소수개수구하기 {

	public static void main(String[] args) {
		int n = 437674;
		int k = 3;

//		int n = 110011;
//		int k = 10;
		System.out.println(solution(n, k));
	}

	public static int solution(int n, int k) {

		String k_number = Integer.toString(n, k);
		String[] arr = k_number.split("0");
		ArrayList<Long> A = new ArrayList<>();
		for (String str : arr) {
			if (str.isEmpty()) {
				continue;
			}
			A.add(Long.parseLong(str));
		}
		int cnt = 0;
		for (int i = 0; i < A.size(); i++) {
			if (isPrimeNumber(A.get(i))) {
				cnt++;
				continue;
			}
		}
		int answer = cnt;
		return answer;
	}
//	에라스토테네스 채 소수판별 메서드
	private static boolean isPrimeNumber(long n) {
		if (n <= 1) {
			return false;
		} else if (n == 2) {
			return true;
		}

		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0) {
				return false;
			}
		return true;
	}
}
