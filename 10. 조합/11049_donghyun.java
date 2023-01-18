package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11409_행렬읩연산횟수의최솟값 {
    public static void main(String [] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int [][] a = new int[n][2];
        int [][] dp = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<n-i; j++) {
                dp[j][j+i] = Integer.MAX_VALUE;
                for(int k=0; k<i; k++) {
                    int cost = dp[j][j+k] + dp[j+k+1][j+i] + a[j][0] * a[j+k][1] * a[j+i][1];
                    dp[j][j+i] = Math.min(dp[j][j+i], cost);
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}

/* dp[i][j]에는 i번과 j번의 곱셈 횟수가 저장된다.
0번째 행렬과 1번째 행렬의 곱셈 횟수가 dp[0][1]에 저장되고

1번째 행렬과 2번째 행렬의 곱셈횟수가 dp[1][2]에 저장되고

0번째 행렬과 dp[1][2]와 곱해서 dp[0][2]에 저장되고 a(bc)

2번째 행렬과 dp[0][1]과 곱해서 (ab)c
전에 저장했던 dp[0][2]와 더 작은 값을 비교해서 dp[0][2]에 저장된다.


예제 1
i = 1, j = 0
dp[0][1] = Integer.MAX_VALUE
k = 0
cost = dp[0][0] + dp[1][1] + a[0][0] * a[0][1] * a[1][1]
     =  0 + 0 + 5 * 3 * 2 = 30
dp[0][1] = Math.min(dp[0][1], cost) = 30 => 0번째와 1번째의 곱  (a * b)



i = 1, j = 1
dp[1][2] = Integer.Max_VALUE
k = 0
cost = dp[1][1] + dp[2][2] + a[1][0] * a[1][1] * a[2][1]
     = 0 + 0 + 3 * 2 * 6 = 36
dp[1][2] = 36 => 1번쨰와 2번째의 곱 (b * c)




i = 2, j = 0
dp[0][2] = Integer.Max_VALUE
k = 0
cost = dp[0][0] + dp[1][2] + a[0][0] * a[0][1] * a[2][1]          
     = 0 + 36 + 5 * 3 * 6 = 126
dp[0][2] = 126 => a(bc)


k = 1
cost = dp[0][1] + dp[2][2] + a[0][0] * a[1][1] * a[2][1]
     = 30 + 0 + 5 * 2 * 6 = 90
dp[0][2] = Math.min(126, 90) = 90 => (ab)c
 */


 
