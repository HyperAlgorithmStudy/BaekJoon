package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_maze {
	static int[][] maze;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // line
		M = Integer.parseInt(st.nextToken()); // column

		visited = new boolean[N][M];
		maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char[] a = st.nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				maze[i][j] = a[j] - 48;
			}
		}

		bfs(0, 0);
		System.out.println(maze[N-1][M-1]);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int now[] = q.poll();
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dx[k]; // search right, left
				int y = now[1] + dy[k]; // search up, down
				if (x >= 0 && y >= 0 && x < N && y < M) { // location validation
					if (maze[x][y] != 0 && !visited[x][y]) { // available moving point & visited validation
						visited[x][y] = true;
						maze[x][y] = maze[now[0]][now[1]] + 1; //update
						q.offer(new int[] { x, y }); //add queue
					}
				}
			}
		}
	}

}