import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static ArrayList<Edge>[] arr;
    static int[] distance;
    static boolean[] vistied;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        distance = new int[N+1];
        for (int i = 0; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        vistied = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr[u].add(new Edge(v,w));
        }
        int S = sc.nextInt();
        int E = sc.nextInt();

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(S,0));
        distance[S] = 0;
        while(!queue.isEmpty()){
            int now = queue.poll().node;
            if(vistied[now]) continue;
            vistied[now] = true;
            for (Edge edge : arr[now]) {
                int next = edge.node;
                int value = edge.value;
                if(distance[next] > distance[now] + value){
                    distance[next] = distance[now] + value;
                    queue.add(new Edge(next,distance[next]));
                }
            }
        }
        System.out.println(distance[E]);
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
