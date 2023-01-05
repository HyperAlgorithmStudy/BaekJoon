import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int temp = 0;
            int max = Math.max(a,b);
            int min = Math.min(a,b);
          
            while(max % min != 0){
                temp = max;
                max = min;
                min = temp % min;
            }
          
            int lcm = a*b / min;
            System.out.println(lcm);
        }

    }

}

// 재귀함수 이용

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int max = Math.max(a,b);
            int min = Math.min(a,b);

            int lcm = a*b / gcd(max,min);
            System.out.println(lcm);
        }

    }
    static int gcd(int max, int min){
        if(min == 0) return max;
        return gcd(min,max%min);
    }

}
