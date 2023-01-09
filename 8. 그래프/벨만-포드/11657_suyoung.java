// 벨만 포드는 전체 과정을 정점의 수만큼 돌리기 때문에, 음수 사이클의 절댓값의 최대 길이가 6천만(M<=6000, |C|<=10,000)이라면 그 과정을 다시 N번 반복하면서 N을 곱한 것만큼 절댓값을 키우게 됨. 
//  N ≤ 500 -> 21억 int 범위 넘음
// 따라서 distance 배열 long 타입으로 해야 함

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Edge[] edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges[i] = new Edge(u,v,w);
        }

        long[] distance = new long[N+1];
        for (int i = 0; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // 벨만-포드 알고리즘
        distance[1] = 0; // 1번 도시에 출발
        for (int i = 1; i < N; i++) { // N-1번 업데이트
            for (int j = 0; j < M; j++) { // 모든 에지 확인
                Edge edge = edges[j];
                if(distance[edge.start] != Integer.MAX_VALUE){ // "<" 도 맞음
                    if(distance[edge.end] > distance[edge.start]+edge.value){
                        distance[edge.end] = distance[edge.start]+edge.value;
                    }
                }
            }
        }
        // 음수 사이클 확인
        boolean isCycle = false;
        for (int i = 0; i < M; i++) { 
            Edge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE){
                if(distance[edge.end] > distance[edge.start]+edge.value){
                    isCycle = true;
                }
            }
        }
        if(!isCycle){
            for (int i = 2; i <=N; i++) {
                if(distance[i] == Integer.MAX_VALUE) // 1번에서 도달할 수 없는 노드
                    System.out.println(-1);
                else
                    System.out.println(distance[i]);
            }
        }else{
            System.out.println(-1);
        }
    }
}
class Edge{
    int start, end, value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}


