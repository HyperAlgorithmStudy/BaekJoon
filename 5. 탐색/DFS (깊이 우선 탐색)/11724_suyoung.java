import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static ArrayList<Integer>[] adjacencyList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        // 인접 리스트 초기화
        for (int i = 1; i < n + 1; i++) {
            adjacencyList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjacencyList[s].add(e); // 양방향 에지
            adjacencyList[e].add(s);
        }
        int count = 0; // 연결 요소 개수
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) { // 방문하지 않은 노드가 없을 때까지 반복
                count++;
                Dfs(i);
            }
        }
        System.out.println(count);
    }

    static void Dfs(int v){  // DSF 재귀함수 구현
        if(visited[v]) return; // 인접 노드에 모두 방문되었을 때 리턴
        visited[v] = true;
        for (Integer i : adjacencyList[v]) {
            if(!visited[i]) Dfs(i);
        }
    }
}


