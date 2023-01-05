import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long gcd = gcd(Math.max(a,b),Math.min(a,b));
        if(c % gcd != 0){
            System.out.println(-1);
        } else{
            long k = c/gcd;
            long[] ans = solve(a,b);
            System.out.println(k*ans[0] + " " + k*ans[1]);
        }

    }
    static long[] solve(long a, long b){
        long[] now = new long[2];
        if(b == 0){
            now[0] = 1; // x = 1
            now[1] = 0; // y = 0
            return now;
        }
        long q = a/b;
        long[] last = solve(b,a % b); // x', y'
        now[0] = last[1]; // x = y'
        now[1] = last[0] - last[1] * q; // y = x' -y' * q
        return now;
    }

    static long gcd(long max, long min){
        if(min == 0) return max;
        return gcd(min,max % min);
    }

}
