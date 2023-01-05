import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long M = sc.nextLong();
        long N = sc.nextLong();
        int[] arr = new int[(int) (N-M+1)];

        for (long i = 2; i <= Math.sqrt(N); i++) {
            long square = i * i;
            long start = (M/square + 1) * square; // ex) M = 10, i = 2 -> (10/4+1)*4 = 12부터 시작
            if(M % square == 0) start = M; // ex) M = 8, i = 2 -> 8부터 시작
          
            for (long j = start; j <= N; j+=square) { 
                arr[(int) (j-M)] = 1; 
            }
        }
      
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=1) cnt++;
        }
        System.out.println(cnt);

    }

}
