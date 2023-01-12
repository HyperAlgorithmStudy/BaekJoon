

import java.util.Scanner;

public class Main {
    static int NUM = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[n+1][n+1];

        // 당연한 값들은 미리 초기화 -> 이것을 통해 뒤에 값들을 유추
        for(int i =0; i <=n; i++){
            dp[i][1] = i;
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for(int i = 2; i <= n; i++){ // i가 2부터 시작인 것은 1은 이미 다 초기화가 되어있기 때문에
            for(int j = 1; j < i; j++){ // j가 1부터인 이유는 1인 것은 다 초기화가 되어있기 때문에, j < i 인 이유는 j==i는 다 초기화가 되어있고 그 이상이면 어처피 0으로 초기화가 되어있기 때문에
                dp[i][j] = (dp[i-1][j]+ dp[i-1][j-1]) % NUM;
            }
        }

        System.out.println(dp[n][k]);
    }
}

// 12!은 int 범위 넘고 20!은 long범위를 넘는다
