import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<Bucket> queue;
    static boolean[][] visited;
    static boolean[] ans;
    static int A,B,C,water;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        visited = new boolean[A+1][B+1];

        // 처음 상태는 정답
        visited[0][0] = true;
        ans = new boolean[C+1];
        ans[C] = true;

        BFS();

        for (int i = 0; i <= C ; i++) {
            if(ans[i]) System.out.print(i+" ");
        }

    }

    static void BFS(){
        queue = new LinkedList<>();
        queue.add(new Bucket(0,0));
        while(!queue.isEmpty()){
            Bucket now = queue.poll();
            // 현재 각 물통의 물의 양
            int a = now.a;
            int b = now.b;
            int c = C - a - b;

            // A 물통 비어있는 경우
            if(a == 0) ans[c] = true;

            // A -> B
            water = Math.min(a, B-b);
            pour(a-water,b+water);

            // A -> C
            water = Math.min(a, C-c);
            pour(a-water,b);

            // B -> A
            water = Math.min(b, A-a);
            pour(a+water, b-water);

            // B -> C
            water = Math.min(b, C-c);
            pour(a, b-water);

            // C -> A
            water = Math.min(c, A-a);
            pour(a+water, b);

            // C -> B
            water = Math.min(c, B-b);
            pour(a, b+water);
        }
    }
    
    static void pour(int x, int y){
        if(!visited[x][y]){
            visited[x][y] = true;
            queue.add(new Bucket(x,y));
        }
    }

}
class Bucket{
    int a;
    int b;

    public Bucket(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
