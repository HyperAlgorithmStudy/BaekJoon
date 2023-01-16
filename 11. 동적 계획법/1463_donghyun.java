

import java.util.Scanner;

public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 0; // 1은 1을 만들기 위해 따로 연산이 필요하지 않으므로 0으로 초기화

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + 1; // 이전 숫자보다 1이 큰 숫자는 1을 추가하는 연산이 한 번 필요하므로 + 1
            if(i % 2 == 0) // 2로 나뉜다면 위에서 dp[i/2]에 값에 2를 한 번 곱하면 i가 나오기 때문에 + 1
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if(i % 3 == 0) // 3으로 나뉜다면 위에서 dp[i/3]에 값에 3을 한 번 곱하면 i가 나오기 때문에 + 1
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }

        System.out.println(dp[n]);
//

    }
}


