import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static ArrayList<Edge>[] arr;
    static int[] distance;
    static boolean[] vistied;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int K = sc.nextInt();

        arr = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }
        distance = new int[V+1];
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        vistied = new boolean[V+1];

        for (int i = 0; i < E; i++) {
            int u =sc.nextInt();
            int v =sc.nextInt();
            int w =sc.nextInt();
            arr[u].add(new Edge(v,w));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(K,0));
        distance[K] = 0;
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
        for (int i = 1; i <= V; i++) {
            if(vistied[i])
                System.out.println(distance[i]);
            else
                System.out.println("INF");
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
