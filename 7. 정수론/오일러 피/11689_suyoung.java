import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); 
        long p = n;
        for (int k = 2; k <= Math.sqrt(n); k++) {
            if(n % k == 0){
                p = p - p/k;
                while(n % k == 0) n /= k;
            }
        }
        if(n > 1) p = p - p/n;
        System.out.println(p);

    }
}

/* 

n=18, p=18
k = 2, p = 18 - 18/2 = 9, n = 18/2 = 9
k= 3, p = 9 - 9/3 = 6, n =9/3/3=1
ans = 6

n=45, p=45
k = 3, p = 45 - 45/2 = 30, n = 45/3/3 = 5
5>1, p = 30-30/5 = 24
ans = 24

*/
