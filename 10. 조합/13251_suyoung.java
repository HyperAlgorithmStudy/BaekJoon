import java.util.Scanner;

public class Main {
    static int size = 51;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int[] D = new int[size];
        int sum = 0;
        for (int i = 0; i < M; i++) {
            D[i] = sc.nextInt();
            sum += D[i];
        }
        int K = sc.nextInt();
        double ans = 0;
        for (int i = 0; i < M; i++) {
            if(D[i] >= K){ // i번째 색깔의 조약돌 개수가 K보다 작으면 모두 같은 색을 뽑을 수 없음
                double prob = 1;
                for (int j = 0; j < K; j++) {
                    prob *= (double) (D[i] - j) /(sum - j);
                }
                ans += prob;
            }
        }
        System.out.println(ans);
    }

}
