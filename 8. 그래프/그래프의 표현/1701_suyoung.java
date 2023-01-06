import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean isBipartite = true;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr = new ArrayList[V+1];
            for (int k = 1; k <= V ; k++) {
                arr[k] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a].add(b);
                arr[b].add(a);
            }
            visited = new boolean[V+1];
            group = new int[V+1];
            for (int j = 1; j <= V; j++) {
                DFS(j);
                if(!isBipartite){
                    System.out.println("NO");
                    break;
                }
            }
            if(isBipartite) System.out.println("YES");
            isBipartite = true;
        }

    }

    static void DFS(int node){
        visited[node] = true;
        for (Integer i : arr[node]) {
            if(!visited[i]){
                group[i] = (group[node]+1) % 2; // 0 or 1
                DFS(i);
            }else if(group[i] == group[node]) isBipartite = false;
        }
    }

}
