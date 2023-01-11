
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
    static boolean[] visit;
    static int answer = 0;
    static int deleteNode = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visit = new boolean[n];
        int root = 0;

        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            if(a != -1){
                tree.get(i).add(a);
                tree.get(a).add(i);
            }
            else
                root = i;

        }

        deleteNode = sc.nextInt();
        if(deleteNode == root){
            System.out.println(0);
        }
        else{
            dfs(root);
            System.out.println(answer);
        }
    }

    static void dfs(int number){
        visit[number] = true;
        int cNode = 0;
        for(int i : tree.get(number)){
            if(visit[i] == false && i != deleteNode){
                cNode++;
                dfs(i);
            }
        }
        if(cNode==0)
            answer++;
    }
}
