import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long M = sc.nextLong();
        long N = sc.nextLong();
        int nSqrt = (int) Math.sqrt(N);
        long[] arr = new long[nSqrt+1];
        for (int i = 2; i <= nSqrt; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(nSqrt); i++) {
            if(arr[i] == 0) continue;
            for (int j = 2 * i; j <= nSqrt; j += i) { // i의 배수
                arr[j] = 0;
            }
        }
        int cnt = 0;
        for (int i = 2; i <= nSqrt; i++) {
            if(arr[i] != 0){
//                System.out.println(arr[i]);
                long a = arr[i];
                while((double)arr[i] <= (double)N/(double)a){
                    if((double)arr[i] >= (double)M/(double)a){
                        cnt++;
                    }
                    a *= arr[i];
//                    System.out.println("cnt = "+cnt+" a = "+a);
                }
            }
        }
        System.out.println(cnt);
    }
}
