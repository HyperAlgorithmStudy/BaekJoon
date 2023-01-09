import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[][] arr = new long[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) arr[i][j] = 0;
                else arr[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[s][e] = 1;
            arr[e][s] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N ; i++) {
                for (int j = 1; j <= N; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        int[] sum = new int[N+1];
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum[i] += arr[i][j];
            }
            if(min > sum[i]){
                min = sum[i];
                ans = i;
            }
        }

        System.out.println(ans);

    }

}

