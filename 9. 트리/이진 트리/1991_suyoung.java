import java.util.Scanner;

public class Main {
    static int[][] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new int[N][2];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String[] tmp = sc.nextLine().split(" ");
            int node = tmp[0].charAt(0) - 'A';
            char left = tmp[1].charAt(0);
            char right = tmp[2].charAt(0);
            if(left == '.')
                tree[node][0] = -1;
            else
                tree[node][0] = left - 'A';
            if(right == '.')
                tree[node][1] = -1;
            else
                tree[node][1] = right - 'A';
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    static void preOrder(int node){ // 전위 순회
        if(node == -1) return;
        System.out.print((char)(node + 'A'));
        preOrder(tree[node][0]);
        preOrder(tree[node][1]);
    }

    static void inOrder(int node){ // 중위 순회
        if(node == -1) return;
        inOrder(tree[node][0]);
        System.out.print((char)(node + 'A'));
        inOrder(tree[node][1]);
    }

    static void postOrder(int node){ // 후위 순회
        if(node == -1) return;
        postOrder(tree[node][0]);
        postOrder(tree[node][1]);
        System.out.print((char)(node + 'A'));
    }


}
