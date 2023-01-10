import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int deleteNode;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        visited = new boolean[N+1];
        tree = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = 0;
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            if(a == -1)
                root = i;
            else{
                tree[i].add(a);
                tree[a].add(i);
            }
        }
        deleteNode = sc.nextInt();

        if(deleteNode == root)
            System.out.println(0);
        else{
            DFS(root);
            System.out.println(ans); 
        }
    }

    static void DFS(int node) {
        visited[node] = true;
        boolean childNode = false;
        for (Integer i : tree[node]) {
            if(!visited[i] && i!= deleteNode){
                childNode = true;
                DFS(i);
            }
        }
        if(!childNode) ans++;

    }

}
