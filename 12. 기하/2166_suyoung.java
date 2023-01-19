import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] x = new long[N+1];
        long[] y = new long[N+1];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }
        x[N] = x[0];
        y[N] = y[0];

        double ans = 0;
        for (int i = 0; i < N; i++) {
            ans += x[i] * y[i+1] - x[i+1] * y[i];
        }
        ans = Math.abs(ans/2);
        System.out.printf("%.1f%n", ans);
    }


}
