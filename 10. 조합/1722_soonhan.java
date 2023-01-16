package combination;

import java.util.Scanner;

public class P1722_permutation {

	public static void main(String[] args) {
		int N, Q;
		long factorial[] = new long[21];
		int S[] = new int[21]; //순열을 담는 배열 
		boolean visited[] = new boolean[21]; //숫자 사용 유무 저장 배열 

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 순열의 길이 
		Q = sc.nextInt(); // 문제의 종류 

		factorial[0] = 1;
		for (int i = 1; i <= N; i++) { // 팩토리얼 초기화 : 각 자릿수에서 만들 수 있는 경우의
			factorial[i] = factorial[i - 1] * i; //ex) 24 6 2 1 
		}
		if (Q == 1) {
			long K = sc.nextLong(); //ex)순열의 길이 N = 4, K = 3번째 순서의 순열 출력하기 
			for (int i = 1; i <= N; i++) { //cnt : 해당 자리에서 몇 번째 숫자를 사용해야 할지를 정하는 변수 
				for (int j = 1, cnt = 1; j <= N; j++) {
					if (visited[j]) // 이미 사용한 숫자는 사용할 수 없음
						continue;
					if (K <= cnt * factorial[N - i]) { //ex) 3 <= 1 * f[2] 현재 순서가 < 해당 자리 순열 수 * cnt 
						K = K - ((cnt - 1) * factorial[N - i]); //K = 3 - (6 * (1-1)) 현재 순서 = 현재 순서 - 해당 자리 순열 수 * cnt - 1 
						S[i] = j; // 현재 자리에 j값 저장하기 i = 1, j = 1
						visited[j] = true; // 숫자 j를 사용 숫자로 체크하기 
						break;
					}
					cnt++;
				}
			}
			for (int i = 1; i <= N; i++) {
				System.out.print(S[i] + " ");
			}
		} else {
			long K = 1; // 순열의 순서 저장 변수 
			for (int i = 1; i <= N; i++) {
				S[i] = sc.nextInt(); // 순열 배열 저장 
				long cnt = 0;
				for(int j = 1; j<S[i]; j++) {
					if(visited[j] == false) {
						cnt++; //미사용 숫자 개수만큼 카운트 
					}
				}
				K += cnt * factorial[N-i]; //자릿수에 따라 순서 더하기  
				visited[S[i]] = true;
			}
			System.out.println(K);
		}

	}

}
