import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int k = 1; k <= N; k++) { // 경유 노드 k
            for (int i = 1; i <= N; i++) { // 출발 노드 i
                for (int j = 1; j <= N; j++) { // 도착 노드 j
                    if(arr[i][k] == 1 && arr[k][j] == 1)
                        arr[i][j] = 1;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}

