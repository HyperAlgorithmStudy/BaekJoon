import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] arr = new long[n][m];
        long max = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Long.parseLong(String.valueOf(line.charAt(j)));
                if(arr[i][j] == 1 && i > 0 && j > 0){
                    arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1])) + 1;
                }
                if(arr[i][j] > max ) max = arr[i][j];
            }
        }
        System.out.println(max * max);
    }
}
