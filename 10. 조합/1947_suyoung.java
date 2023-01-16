import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] D = new long[1000001];
        long mod = 1000000000;
        D[1] = 0;
        D[2] = 1;
        for (int i = 3; i <= N; i++) {
            D[i] = (i-1) * (D[i-1] + D[i-2]) % mod;
        }
        System.out.println(D[N]);
    }

}
