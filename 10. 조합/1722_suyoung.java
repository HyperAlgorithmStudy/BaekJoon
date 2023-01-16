import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        long[] Factorial = new long[N];
        Factorial[0] = 1;
        for (int i = 1; i < N; i++) {
            Factorial[i] = Factorial[i-1] * i;
        }
        boolean[] isUsed = new boolean[N+1];
        int[] arr = new int[N+1];
        // 1번
        if(Q == 1){
            long K = sc.nextLong();
            for (int i = 1; i <= N; i++) { // 자릿수
                int cnt = 1;
                for (int j = 1; j <= N; j++) {
                    if(isUsed[j]) continue;
                    if(K <= cnt * Factorial[N-i]){
                        K = K - (cnt - 1) * Factorial[N-i];
                        arr[i] = j;
                        isUsed[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for (int i = 1; i <= N; i++) {
                System.out.print(arr[i] + " ");
            }

        }
        // 2번
        else if(Q == 2){
            long K = 1;
            for (int i = 1; i <= N; i++) {
                int cnt = 0;
                arr[i] = sc.nextInt();
                for (int j = 1; j < arr[i]; j++) {
                    if(!isUsed[j]) cnt++;
                }
                K += cnt * Factorial[N-i];
                isUsed[arr[i]] = true;
            }
            System.out.println(K);
        }

    }

}
