import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = sc.nextInt();
        }
        int cnt = 0;
        for (int i = N-1; i >= 0 ; i--) {
            if(coin[i] <= K){
                cnt += (K / coin[i]);
                K = K % coin[i];
            }
        }
        System.out.println(cnt);
    }
}
