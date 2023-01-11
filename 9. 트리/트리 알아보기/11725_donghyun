

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static boolean[] visit;
    static int[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visit = new boolean[n+1];
        answer = new int[n+1];

        for(int i = 0 ; i <= n; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1);
        bfs(1);
        for(int i = 2; i < answer.length;i++){
            System.out.println(answer[i]);
        }

    }

    public static void dfs(int start){
         visit[start] = true;
         for(int i : tree.get(start)){
             if(!visit[i]){
                 answer[i] = start;
                 dfs(i);
             }
         }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i : tree.get(now)){
                if(!visit[i]){
                    visit[i] = true;
                    q.offer(i);
                    answer[i] = now;
                }
            }
        }

    }
}
/*
               5
          3    3    3                   2         7
     6    6    6    6    6         4    4    4    4    4
1    1    1    1    1    1    1    1    1    1    1    1    1
*/

/*
1 -> 4 6 -> 3 4 -> 7 2 3 -> 5 7 2 -> 5 7 -> 5
 */
