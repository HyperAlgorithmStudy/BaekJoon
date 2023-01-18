// 참고: https://subbak2.com/m/79

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[][][] D;
    static ArrayList<Integer> numbers;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numbers = new ArrayList<>();
        while(true){
            int number = sc.nextInt();
            if(number == 0) break;
            numbers.add(number);
        }
        N = numbers.size();
        D = new int[N+1][5][5];

        System.out.println(DDR(0,0,0));
    }

    static int DDR(int n, int left, int right) {
        if(n == N) return 0;
        if(D[n][left][right] != 0) return D[n][left][right];

        int leftScore = score(left, numbers.get(n)) + DDR(n+1, numbers.get(n), right);
        int rightScore = score(right, numbers.get(n)) + DDR(n+1, left, numbers.get(n));
        return D[n][left][right] = Math.min(leftScore, rightScore);
    }

    static int score(int from, int to){
        if(from == to) return 1;
        if(from == 0) return 2;
        if(Math.abs(from-to) == 2) return 4; // 차이 2 - 맞은편
        return 3;
    }
}
