import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] D = new int[N + 1];
        D[1] = 0;
        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1; // 밑에서 나누기 계산이 D[i]를 더 작게 만든다면 교체됨
            if (i % 2 == 0)
                D[i] = Math.min(D[i], D[i / 2] + 1); // 1을 더하는 것은 D는 결과가 아닌 계산한 횟수를 저장하는 것이기 때문ㅇ
            if (i % 3 == 0)
                D[i] = Math.min(D[i], D[i / 3] + 1);
        }
        System.out.println(D[N]);
    }

}
