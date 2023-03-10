import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] D = new int[N + 2];
        int[] T = new int[N + 2]; // μΌμ
        int[] P = new int[N + 2]; // λ
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        for (int i = N; i > 0; i--) {
            if(i + T[i] - 1 > N)
                D[i] = D[i + 1];
            else
                D[i] = Math.max(D[i + T[i]] + P[i], D[i + 1]);
        }
        System.out.println(D[1]);
    }

}
