import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long K = sc.nextLong();
        long [][] cases = new long[N+M+1][N+M+1]; // cases[남은 총 문자 개수][남은 z 개수]
        for (int i = 0; i <= N+M ; i++) {
            for (int j = 0; j <= i; j++) { // 남은 z 개수 <= 남은 총 문자 개수
                if(j == 0 || j == i){ // a 또는 z 밖에 안 남았을 때
                    cases[i][j] = 1;
                }else{
                    cases[i][j] = cases[i-1][j] + cases[i-1][j-1];
                    if(cases[i][j] > K) cases[i][j] = K + 1; // 범위 초과 방지
                }
            }
        }

        if(cases[N+M][M] < K){
            System.out.println(-1); return;
        }
        StringBuilder sb = new StringBuilder();
        while(!(N == 0 && M == 0)){
            if(cases[N+M-1][M] >= K){ // a를 선택했을 때 남은 문자로 만들 수 있는 경우의 수가 K보다 클 때
                sb.append("a");
                N--;
            }else{
                sb.append("z");
                K -= cases[N+M-1][M];
                M--;
            }
        }
        System.out.println(sb);

    }

}
