import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] ancestor, depth;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        ancestor = new int[N+1];
        depth = new int[N+1];
        tree = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        DFS(1,1,1);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }
        System.out.println(sb);

    }
    static void DFS(int parent, int node, int dep) {
        visited[node] = true;
        depth[node] = dep;
        ancestor[node] = parent;
        for (Integer i : tree[node]) {
            if (!visited[i]) DFS(node,i, dep + 1);
        }
    }
    static int LCA(int a, int b){
        // 더 깊은 노드가 b
        if(depth[a] > depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }
       while(depth[a] != depth[b]){
           b = ancestor[b];
       }
       while(a != b){
           a = ancestor[a];
           b = ancestor[b];
       }
       return a;
    }

}

