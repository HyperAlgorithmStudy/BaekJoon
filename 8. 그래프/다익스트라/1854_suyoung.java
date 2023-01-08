import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static ArrayList<Edge>[] arr;
    static PriorityQueue<Integer>[] distanceQueue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        // 각 노드별로 1~K번째 최단경로 저장
        distanceQueue = new PriorityQueue[N+1];
        for (int i = 0; i <= N; i++) {
            distanceQueue[i] = new PriorityQueue<>((a,b)-> b-a); // 내림차순 정렬 (가장 큰 수 poll 할 수 있도록)
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr[u].add(new Edge(v,w));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1,0));
        distanceQueue[1].add(0);
        while(!queue.isEmpty()){
            Edge now = queue.poll();
            for (Edge next : arr[now.node]) {
                // 저장된 경로가 K가 안 되면 추가
                if(distanceQueue[next.node].size() < K){
                    distanceQueue[next.node].add(now.value + next.value);
                    queue.add(new Edge(next.node,now.value + next.value));
                }
                // 저장된 경로가 K이고, 가장 큰 경로보다 작을 때만 추가
                else if(distanceQueue[next.node].peek() > now.value + next.value){
                    distanceQueue[next.node].poll();
                    distanceQueue[next.node].add(now.value + next.value);
                    queue.add(new Edge(next.node,now.value + next.value));
                }

            }
        }
        for (int i = 1; i <= N; i++) {
            if(distanceQueue[i].size() == K){
                System.out.println(distanceQueue[i].peek());
            }else{
                System.out.println(-1);
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int node;
    int value;

    public Edge(int node, int value) {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}
