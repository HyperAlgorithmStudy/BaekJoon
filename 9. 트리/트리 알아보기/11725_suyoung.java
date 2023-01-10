import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            tree[s].add(e);
            tree[e].add(s);
        }

        ans = new int[N+1];
        ans[1] = 1;

        DFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(ans[i]);
        }
    }

    static void DFS(int node) {
        for (Integer i : tree[node]) {
            if(ans[i] == 0){
                ans[i] = node;
                DFS(i);
            }
        }
    }
    
}
