import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static int treeSize;
    static int startIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int temp = N;
        int height = 0;
        while(temp != 0){
            temp = temp / 2;
            height++;
        }

        treeSize = (int) Math.pow(2, height + 1);
        tree = new long[treeSize];
        startIdx = (int) Math.pow(2, height);

        for (int i = 0; i < treeSize; i++) {
            tree[i] = Long.MAX_VALUE;
        }

        for (int i = startIdx; i < startIdx + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(getMin(a + startIdx - 1,b + startIdx - 1));
            }
        }

    static long getMin(int s, int e) {
        long min = Long.MAX_VALUE;
        while(s <= e){
            if(s % 2 == 1){
                min = Math.min(min, tree[s]);
            }
            if(e % 2 == 0){
                min = Math.min(min, tree[e]);
            }
            s = (s+1)/2;
            e = (e-1)/2;
        }
        return min;
    }

    static void setTree() {
        int idx = treeSize - 1;
        while(idx != 1){
            if(tree[idx/2] > tree[idx])
                tree[idx/2] = tree[idx];
            idx--;
        }
    }


}

