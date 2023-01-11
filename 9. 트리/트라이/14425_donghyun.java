

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            map.put(sc.next(), 1);
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            if(map.containsKey(sc.next()))
                count++;
        }
        System.out.println(count);
    }
}
