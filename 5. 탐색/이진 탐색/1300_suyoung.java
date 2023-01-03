import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int result = 0;
        int start = 1;
        int end = K;
        while(start <= end){
            int mid = (start + end) / 2;
            int cnt = 0;
            for (int i = 1; i < N + 1; i++) {
                cnt += Math.min(mid/i, N);
            }
            if(cnt < K){
                start = mid + 1;
            }else{
                result = mid;
                end = mid - 1;
            }
        }
        System.out.println(result);
    }

}