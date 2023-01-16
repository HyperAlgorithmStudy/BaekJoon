
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] d = new int[n+2];
        int[] t = new int[n+1];
        int[] p = new int[n+1];

        for(int i = 1; i <= n; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = n; i > 0; i--) {
            // DP[i] + T[i]가 N+1보다 크다면, i 날짜에 시작하는 일을 할 수 없다는 뜻
            if (i + t[i] > n + 1)
                d[i] = d[i+1]; // i 날짜에 i의 일을 하지 못한다면 i+1 날짜부터 시작한 최댓값과 i 날짜에 시작한 최댓값이 같음
            // DP[i] + T[i]가 N+1과 작거나 같다면, i 날짜에 시작하는 일을 할 수 있다는 뜻
            else {
                d[i] = Math.max(d[i+1], p[i] + d[i+t[i]]); // i 날짜의 일을 하면, i의 금액과 i일을 하고 난 후, DP[i+T[i]]의 값을 벌 수 있고, 하지 않는다면, DP[i+1]의 값을 벌 수 있기 때문이다.
            }
        }
        System.out.println(d[1]);
    }
}

/*

DP 배열은 그 날짜부터 시작했을 때의 최대 수입이다.



예를 들어 DP[5]는 5일부터 N일까지 최댓값.

우리가 원하는 것은 1일부터이므로 DP[1]의 값을 구해주면 된다.



DP[i] + T[i]가 N+1보다 크다면, i 날짜에 시작하는 일을 할 수 없다는 뜻이다.

때문에, 무조건 DP[i]의 값은 DP[i+1]이 되어야한다.

i 날짜에 i의 일을 하지 못한다면 i+1 날짜부터 시작한 최댓값과 i 날짜에 시작한 최댓값이 같기 때문이다.



DP[i] + T[i]가 N+1과 작거나 같다면, i 날짜에 시작하는 일을 할 수 있다는 뜻이다.

하지만, i날짜의 일을 하는 것이 최댓값을 보장해준다고 할 수 없다.

때문에, DP[i+1]과 P[i] + DP[i+T[i]]의 값 중 최댓값이 DP[i]가 되어야한다.

i 날짜의 일을 하면, i의 금액과 i일을 하고 난 후, DP[i+T[i]]의 값을 벌 수 있고,

하지 않는다면, DP[i+1]의 값을 벌 수 있기 때문이다.
 */
