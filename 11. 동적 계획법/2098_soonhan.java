package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2098_tsp {
	static int N;
	static int[][] map;
	static int[][] dp;
	static int INF;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		INF = 11000000;
		map = new int[N][N];
		// i : 현재 위치한 도시, j : 지금 까지 방문한 도시 2진수로 표현
		dp = new int[N][(1 << N) - 1];
		// ex) 1 << 5 = 100000(2) -> 우리의 최대값은 11111임으로 1을 빼준다.

		// map에 입력값 넣어주기
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				map[i][j] = cost;
			}
		}

		// dp배열 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], INF);
		}
		// dfs로 탐색
		System.out.println(dfs(0, 1));
	}

	// 어느 도시에서 시작하든지 최소 비용이 같기 때문에 0번도시 부터 시작
	// param : city - 현재 위치한 도시 위치, visited - 지금까지 방문한 도시 2진수

	private static int dfs(int city, int visited) {
		// 모든 도시를 방문 했다면
		if (visited == (1 << N) - 1) {
			if (map[city][0] == 0) {
				return INF; // ?
			}
			return map[city][0]; // 현재 도시 -> 0번째 도시 이동 거리
		}

		if (dp[city][visited] != INF) {
			return dp[city][visited];
		}
		// 현재 도시에서 각 i의 도시로 이동한 경우에 대해 DFS 수행
		for (int i = 0; i < N; i++) {
			// 한번이라도 그 도시를 방문했는데 다시 그 도시를 방문하는 경우 예외 처리
			if ((visited & (1 << i)) == 0 && map[city][i] != 0) {
				//d[i][j] = 현재 있는 도시가 i이고 이미 방문한 도시들의 집합이 j일때, 방문하지 않은 나머지
				//도시들을 모두 방문한 뒤 출발 도시로 돌아올 때 드는 최소 비용
				//즉, 방문해야하는 도시들 까지 가는 최소비용 
				//dfs(다음도시, 다음도시 방문했다고 가정) + 여기서 다음 도시까지의 거리와 최소거리 비교
				dp[city][visited] = Math.min(dp[city][visited], 
						dfs(i, visited | (1 << i)) + map[city][i]);
			}
		}
		return dp[city][visited];
	}

}
