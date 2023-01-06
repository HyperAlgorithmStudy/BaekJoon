import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        for (int i = 1; i <= N ; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }
        
        dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            DFS(i);
        }
        
        for (int i : dp) {
            if(max < i) max = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if(dp[i] == max) sb.append(i).append(" ");
        }
        System.out.println(sb);
        
    }

    static void DFS(int node){
        visited[node] = true;
        for (Integer i : arr[node]) {
            if(!visited[i]){
                dp[i]++;
                DFS(i);
            }
        }
    }

}
