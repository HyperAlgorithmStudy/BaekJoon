import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] distance;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();
        arr = new ArrayList[N+1];
        for (int i = 1; i <= N ; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
        }

        distance = new int[N+1];
        for (int i = 0; i <= N; i++) {
            distance[i] = -1;
        }

        BFS(X);

        boolean exist = false;
        for (int i = 1; i <= N; i++) {
            if(distance[i] == K){
                System.out.println(i);
                exist = true;
            }
        }
        if(!exist) System.out.println(-1);
    }

    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        distance[node] = 0;
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int i : arr[now]) {
                if(distance[i] == -1){
                    queue.add(i);
                    distance[i] = distance[now] + 1;
                }
            }
        }
    }

}
