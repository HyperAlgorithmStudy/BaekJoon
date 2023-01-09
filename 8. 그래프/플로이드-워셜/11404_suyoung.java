import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[][] distance = new long[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) distance[i][j] = 0;
                else distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            if(distance[u][v] > w) distance[u][v] = w;
        }
        for (int k = 1; k <= N; k++) { // 경유 노드 k
            for (int i = 1; i <= N; i++) { // 출발 노드 i
                for (int j = 1; j <= N; j++) { // 도착 노드 j
                    distance[i][j] = Math.min(distance[i][j],distance[i][k] + distance[k][j]);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(distance[i][j] == Integer.MAX_VALUE)
                    System.out.print("0 ");
                else
                    System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }

    }
}

