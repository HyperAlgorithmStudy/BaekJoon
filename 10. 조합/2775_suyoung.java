import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] D = new int[30][30];
        for (int i = 0; i < 15; i++) {
            D[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                D[i][j] = D[i-1][j] + D[i][j-1];
            }
        }
        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(D[k][n]);
        }

    }

}
