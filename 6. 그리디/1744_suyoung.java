import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder()); // 양수는 내림차순
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int sum = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(num > 1){
                plus.add(num);
            }else if(num < 0){
                minus.add(num);
            }else if(num ==1){
                sum += num;
            }else{ //0
                zero = 1;
            }
        }

        // 양수
        while(plus.size()>1){
            int a = plus.remove();
            int b = plus.remove();
            sum += a*b;
        }
        if(!plus.isEmpty()) sum += plus.poll();

        // 음수
        while(minus.size()>1){
            int a = minus.remove();
            int b = minus.remove();
            sum += a*b;
        }
        if(!minus.isEmpty() && zero != 1){ // 음수가 하나 남았지만 0이 없는 경우
            sum += minus.poll();
        }

        System.out.println(sum);
    }
}