import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long gcd = gcd(Math.max(a,b),Math.min(a,b));
        
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < gcd; j++) {
            sb.append(1);
        }
        System.out.println(sb);
    }
    
    static long gcd(long max, long min){
        if(min == 0) return max;
        return gcd(min,max%min);
    }

}
