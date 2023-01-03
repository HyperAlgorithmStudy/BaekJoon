import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] card = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            card[i] = sc.nextInt();
            pq.add(card[i]);
        }

        int ans = 0;
        while(pq.size()>1){
            int a = pq.remove();
            int b = pq.remove(); // poll은 NullPointerException
            ans += a+b;
            pq.add(a+b);
        }
        System.out.println(ans);
    }
}