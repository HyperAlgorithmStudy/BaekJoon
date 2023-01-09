import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int E = sc.nextInt();
        int M = sc.nextInt();

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges[i] = new Edge(u,v,w);
        }

        long[] distance = new long[N];
        Arrays.fill(distance,Long.MIN_VALUE);

        long[] cityMoney = new long[N];
        for (int i = 0; i < N; i++) {
            cityMoney[i] = sc.nextInt();
        }

        // 변형된 벨만-포드 알고리즘
        distance[S] = cityMoney[S]; // S번 도시에서 출발
        for (int i = 0; i < 2*N; i++) { // N-1번 업데이트, 0번 노드부터 시작
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if(distance[edge.start] == Long.MIN_VALUE)
                    continue; // 출발 노드가 방문하지 않은 노드면 패스
                else if(distance[edge.start] == Long.MAX_VALUE) // 양수 사이클
                    distance[edge.end] = Long.MAX_VALUE;
                else if(distance[edge.end] < distance[edge.start] - edge.cost + cityMoney[edge.end]){
                        if(i >= N-1) // N-1번 반복 후 업데이트되는 노드는 양수 사이클 노드
                            distance[edge.end] = Long.MAX_VALUE;
                        else // 비용보다 버는 돈이 많으면 업데이트
                            distance[edge.end] = distance[edge.start] - edge.cost + cityMoney[edge.end];
                }
            }
        }
        if(distance[E] == Long.MIN_VALUE) System.out.println("gg");
        else if(distance[E] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[E]);
    }
}

class Edge{
    int start, end, cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}


