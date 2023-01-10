import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static PriorityQueue<Edge> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        queue = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();
            queue.add(new Edge(s,e,w));
        }

        arr = new int[V+1];
        for (int i = 0; i <= V; i++) {
            arr[i] = i;
        }

        int edgeNum = 0;
        int ans = 0;
        while(edgeNum < V -1){ // 유니온파인드 연산으로 !queue.isEmpty() 조건으로도 같은 결과 나옴
            Edge now = queue.poll();
            if(find(now.start) != find(now.end)){
                ans += now.value;
                edgeNum++;
                union(now.start, now.end);
            }
        }
        System.out.println(ans);
    }
  
    static void union(int a, int b){
        arr[find(b)] = find(a);
    }
  
    static int find(int a){
        if(arr[a] == a) return a;
        return arr[a] = find(arr[a]);
    }
}

class Edge implements Comparable<Edge>{
    int start,end,value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}
